package com.matheuskittler.weather_report.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "https://api.open-meteo.com"

    fun createWeatherAPI(): IWeatherAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(IWeatherAPI::class.java)
    }
}