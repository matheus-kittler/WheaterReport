package com.matheuskittler.weather_report.di

import com.matheuskittler.weather_report.service.AppDispatcher
import org.koin.dsl.module
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.IWeatherService
import com.matheuskittler.weather_report.service.WeatherService
import com.matheuskittler.weather_report.ui.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

private const val BASE_URL = "https://api.open-meteo.com"

val appModule = module {
    // Configuração do Retrofit
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Declaração do serviço WeatherService
    single { WeatherService(get()) }

    // Configuração do serviço de API do tempo
    single<IWeatherAPI> { get<Retrofit>().create(IWeatherAPI::class.java) }

    // Definição e fornecimento de IWeatherService
    single<IWeatherService> { get<WeatherService>() }

    // Fornecimento do AppDispatcher
    single<AppDispatcher> {
        object : AppDispatcher {
            override var main: CoroutineContext = Dispatchers.Main
            override var io: CoroutineContext = Dispatchers.IO
        }
    }

    // ViewModel
    viewModel { MainViewModel(get(), get()) }
}
