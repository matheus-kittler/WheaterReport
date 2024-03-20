package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Location
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherAPI {
    @GET("/v1/forecast")
    suspend fun getWeatherReport(
        @Query("latitude") latitude: String,
        @Query("longitude") longitude: String,
        @Query("forecast_days") forecastDays: Int,
        @Query("current") current: List<String>,
        @Query("timezone") timezone: String,
        @Query("hourly") hourly: List<String>,
        @Query("daily") daily: List<String>
    ): Response<Location>
}