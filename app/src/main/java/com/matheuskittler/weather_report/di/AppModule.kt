package com.matheuskittler.weather_report.di

import com.matheuskittler.weather_report.service.AppDispatcher
import org.koin.dsl.module
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.WeatherService
import com.matheuskittler.weather_report.ui.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

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
    single {object : AppDispatcher {
        override var main: CoroutineContext = Dispatchers.Main
        override var io: CoroutineContext = Dispatchers.IO
    }}
    viewModel {
        MainViewModel(get(), get())
    }
}