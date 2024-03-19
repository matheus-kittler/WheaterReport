package com.matheuskittler.weather_report.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.service.IWeatherAPI
import kotlinx.coroutines.launch

class MainViewModel(private val weatherAPI: IWeatherAPI) : ViewModel() {
    private val _location = MutableLiveData<Location>()
    val location: LiveData<Location> = _location

    fun fetchWeatherData(latitude: String, longitude: String, forecastDays: Int, temperature: String, hourly: String) {
        viewModelScope.launch {
            try {
                val response = weatherAPI.getWeatherReport(latitude, longitude, forecastDays, temperature, hourly)
                if (response.isSuccessful) {
                    _location.value = response.body()
                } else {
                    // Trate o erro de acordo com sua lógica de aplicação
                }
            } catch (e: Exception) {
                // Trate o erro de acordo com sua lógica de aplicação
            }
        }
    }
}