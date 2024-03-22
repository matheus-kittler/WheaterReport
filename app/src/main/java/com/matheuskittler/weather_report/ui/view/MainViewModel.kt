package com.matheuskittler.weather_report.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.service.AppDispatcher
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.IWeatherService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val service: IWeatherService, private val dispatcher: AppDispatcher) : ViewModel() {
    private val _location = MutableLiveData<Location>()
    val errorText = MutableLiveData<String>()
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading
    val location: LiveData<Location> = _location

    fun fetchWeatherData(latitude: String, longitude: String, forecastDays: Int, current: List<String>, timezone: String, hourly: List<String>, daily: List<String>) {
        viewModelScope.launch(dispatcher.io) {

            _isLoading.value = true
            try {
                service.getWeatherData(latitude, longitude, forecastDays, current, timezone, hourly, daily).collect {
                    _location.postValue(it)
                    _isLoading.value = false
                }
            } catch (e: Exception) {
                errorText.postValue(e.message)
            }
        }
    }
}