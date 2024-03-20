package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Location
import kotlinx.coroutines.flow.Flow

interface IWeatherService {
    suspend fun getWeatherData(
        latitude: String,
        longitude: String,
        forecastDays: Int,
        current: List<String>,
        timezone: String,
        hourly: List<String>,
        daily: List<String>
    ): Flow<Location>
}