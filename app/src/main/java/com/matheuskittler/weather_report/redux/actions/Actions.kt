package com.matheuskittler.weather_report.redux.actions

import com.matheuskittler.weather_report.model.Location

sealed class Action {
    // Ação para buscar dados do clima
    data class FetchData(
        val latitude: String,
        val longitude: String,
        val forecastDays: Int,
        val temperature: String,
        val hourly: String
    ) : Action()

    // Ação para indicar que os dados do clima foram carregados com sucesso
    data class DataLoaded(val location: Location) : Action()

    // Ação para indicar um erro ao carregar os dados do clima
    data class DataError(val errorMessage: String) : Action()
}