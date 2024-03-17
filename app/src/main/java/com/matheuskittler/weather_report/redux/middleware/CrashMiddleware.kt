package com.matheuskittler.weather_report.redux.middleware

import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.middleware

val crashReporter = middleware<AppState> { store, next, action ->
    try {
        return@middleware next(action)
    } catch (e: Exception) {
        throw e
    }
}