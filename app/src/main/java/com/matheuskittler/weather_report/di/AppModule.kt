package com.matheuskittler.weather_report.di

import android.content.res.Resources
import android.net.Network
import com.matheuskittler.weather_report.redux.state.AppState
import com.matheuskittler.weather_report.redux.store.store
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.IWeatherService
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.get
import org.koin.dsl.module
import org.reduxkotlin.Store

val reduxModule = module {
    single<Store<AppState>> {
        store
    }
}

val networkModule = module {

    single<Resources> { androidContext().resources }
//    module + NetworkModule

//    single<IWeatherService> { WeatherService(get()) }
}

val appModules = listOf(reduxModule, networkModule)