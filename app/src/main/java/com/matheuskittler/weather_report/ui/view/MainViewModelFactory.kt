package com.matheuskittler.weather_report.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheuskittler.weather_report.service.IWeatherAPI

class MainViewModelFactory(private val weatherAPI: IWeatherAPI) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(weatherAPI) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}