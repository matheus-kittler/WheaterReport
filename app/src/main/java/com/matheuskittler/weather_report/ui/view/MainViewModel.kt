package com.matheuskittler.weather_report.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.service.IWeatherAPI
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val weatherAPI: IWeatherAPI) : ViewModel() {
    private val _location = MutableLiveData<Location>()
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading
    val location: LiveData<Location> = _location

    fun fetchWeatherData(latitude: String, longitude: String, forecastDays: Int, current: List<String>, timezone: String, hourly: List<String>, daily: List<String>) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = weatherAPI.getWeatherReport(latitude, longitude, forecastDays, current, timezone, hourly, daily)
                if (response.isSuccessful) {

                    viewModelScope.launch {
                        delay(2000)
                        _isLoading.value = false
                        _location.value = response.body()
                    }
                } else {
                    // Trate o erro de acordo com sua lógica de aplicação
                }
            } catch (e: Exception) {
                // Trate o erro de acordo com sua lógica de aplicação
            }
        }
    }
}