package com.matheuskittler.weather_report.redux.state

import com.matheuskittler.weather_report.model.Location

data class AppState(
    val isConnected: Boolean,
    val location: Location
)