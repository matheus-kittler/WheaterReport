package com.matheuskittler.weather_report.di

import android.net.Network
import com.matheuskittler.weather_report.redux.state.AppState
import com.matheuskittler.weather_report.redux.store.store
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.IWeatherService
import com.matheuskittler.weather_report.service.WeatherService
import org.koin.dsl.module
import org.reduxkotlin.Store

val reduxModule = module {
    single<Store<AppState>> {
        store
    }
}

val networkModule = module {
    single {

    }

//    single<IWeatherService> { WeatherService(get()) }
}

val appModules = listOf(reduxModule, networkModule)