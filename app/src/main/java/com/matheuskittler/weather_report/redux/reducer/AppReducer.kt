package com.matheuskittler.weather_report.redux.reducer

import com.matheuskittler.weather_report.redux.actions.Action
//import com.matheuskittler.weather_report.redux.actions.ConnectionChanged
import com.matheuskittler.weather_report.redux.state.AppState
import org.reduxkotlin.Reducer
import org.reduxkotlin.TypedReducer

//fun <State, Action> TypedReducer(reduceFunction: (State, Action) -> State): TypedReducer<State, Action> {
//    return object : TypedReducer<State, Action> {
//        override fun invoke(state: State, action: Action): State {
//            return reduceFunction(state, action)
//        }
//    }
//}
//
//val reducer = TypedReducer<AppState, Action> { state, action ->
//    when (action) {
//        is Action.FetchData -> {
//            // Atualiza o estado indicando que os dados estão sendo carregados
//            state.copy(isLoading = true)
//        }
//        is Action.DataLoaded -> {
//            // Atualiza o estado com os dados carregados
//            state.copy(location = action.location, isLoading = false)
//        }
//        is Action.DataError -> {
//            // Atualiza o estado com a mensagem de erro
//            state.copy(errorMessage = action.errorMessage, isLoading = false)
//        }
//        else -> {
//            // Retorna o estado sem fazer alterações
//            state
//        }
//    }
//}

typealias AppReducer = Reducer<AppState>

// Define o reducer
val reducer: AppReducer = { state, action ->
    when (action) {
        is Action.FetchData -> {
            // Atualiza o estado indicando que os dados estão sendo carregados
            state.copy(isLoading = true)
        }
        is Action.DataLoaded -> {
            // Atualiza o estado com os dados carregados
            state.copy(location = action.location, isLoading = false)
        }
        is Action.DataError -> {
            // Atualiza o estado com a mensagem de erro
            state.copy(errorMessage = action.errorMessage, isLoading = false)
        }
        else -> {
            // Retorna o estado sem fazer alterações
            state
        }
    }
}
