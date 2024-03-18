package com.matheuskittler.weather_report.redux.thunks

import com.matheuskittler.weather_report.redux.actions.Action
import com.matheuskittler.weather_report.redux.state.AppState
import com.matheuskittler.weather_report.service.getWeatherData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.reduxkotlin.thunk.ThunkMiddleware

fun ThunkMiddleware(extraArgument: Any? = null): ThunkMiddleware<AppState> = { store ->
    { next ->
        { action ->
            when (action) {
                // Tratamento da ação FetchWeatherData
                is Action.FetchData -> {
                    // Inicializa um escopo de coroutine para execução assíncrona
                    val coroutineScope = CoroutineScope(Dispatchers.IO)
                    coroutineScope.launch {
                        // Realiza a chamada assíncrona para obter os dados do clima
                        try {
                            val location = getWeatherData(
                                action.latitude,
                                action.longitude,
                                action.forecastDays,
                                action.temperature,
                                action.hourly
                            )
                            // Despacha a ação com os dados obtidos
                            store.dispatch(Action.DataLoaded(location))
                        } catch (e: Exception) {
                            // Em caso de erro, despacha uma ação de erro
                            store.dispatch(
                                Action.DataError(
                                    e.message ?: "Erro desconhecido"
                                )
                            )
                        }
                    }
                }
                else -> next(action)
            }
        }
    }
}
