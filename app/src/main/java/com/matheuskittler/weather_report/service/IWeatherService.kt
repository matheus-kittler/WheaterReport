package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Location
import kotlinx.coroutines.flow.Flow

interface IWeatherService {
    suspend fun getWeather() : Flow<Location>
}