package com.matheuskittler.weather_report.redux.middleware

import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.Dispatcher
import org.reduxkotlin.thunk.Thunk
import org.reduxkotlin.thunk.ThunkMiddleware

fun createThunkMiddleware(extraArgument: Any? = null): ThunkMiddleware<AppState> = { store ->
    { next: Dispatcher ->
        { action: Any ->
            if (action is Function<*>) {
                try {
                    (action as Thunk<AppState>)(store.dispatch, store.getState, extraArgument)
                } catch (e: Exception) {
                    throw IllegalArgumentException()
                }
            }
        }
    }
}