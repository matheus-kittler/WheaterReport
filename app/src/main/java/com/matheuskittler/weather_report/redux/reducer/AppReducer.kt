package com.matheuskittler.weather_report.redux.reducer

import com.matheuskittler.weather_report.redux.actions.ConnectionChanged
import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.Reducer

val reducer: Reducer<AppState> = { state, action ->
    when(action) {
        is ConnectionChanged -> state.copy(isConnected = action.isConnected)
        else -> state
    }
}