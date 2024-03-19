package com.matheuskittler.weather_report.di

import org.koin.dsl.module
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.open-meteo.com"

val appModule = module {
    // Declaração do serviço WeatherService
    single { WeatherService(get()) }

    // Configuração do Retrofit e criação da instância de IWeatherAPI
    single<IWeatherAPI> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(IWeatherAPI::class.java)
    }
}