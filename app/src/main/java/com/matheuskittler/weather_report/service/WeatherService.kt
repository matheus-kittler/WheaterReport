package com.matheuskittler.weather_report.service

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class WeatherService {

    private val baseUrl = "https://api.open-meteo.com"

    @OptIn(DelicateCoroutinesApi::class)
    fun getWeather(latitude: String, longitude: String, forecastDays: Int, hourly: String) {

        val api = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build().create(IWeatherAPI::class.java)


        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getWeatherReport(latitude, longitude, forecastDays, hourly)
            Log.d( "Response", "Response: ${response.body()}")
            if (response.isSuccessful) {
                response.body()
            }
        }
    }
}