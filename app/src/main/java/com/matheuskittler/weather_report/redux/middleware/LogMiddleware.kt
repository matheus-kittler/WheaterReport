package com.matheuskittler.weather_report.redux.middleware

import android.util.Log
import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.middleware

val loggingMiddleware = middleware<AppState> { store, next, action ->
    Log.d("Redux", action.toString())
    next(action)
}