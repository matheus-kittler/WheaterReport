package com.matheuskittler.weather_report.redux.store

import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.redux.middleware.crashReporter
import com.matheuskittler.weather_report.redux.middleware.createThunkMiddleware
import com.matheuskittler.weather_report.redux.middleware.loggingMiddleware
import com.matheuskittler.weather_report.redux.reducer.reducer
import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.createStore

val store = createStore(
    reducer, AppState(false, Location("", "", "", "", "", "", "", "", "")), applyMiddleware(
        createThunkMiddleware(),
        loggingMiddleware,
        crashReporter,
    )
)