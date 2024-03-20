package com.matheuskittler.weather_report.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.ListHorizontal
import com.matheuskittler.weather_report.ui.component.LoadingIndicator
import com.matheuskittler.weather_report.ui.component.TextFieldLocation
import com.matheuskittler.weather_report.ui.component.WeatherList
import com.matheuskittler.weather_report.ui.view.CURRENT_QUERIES
import com.matheuskittler.weather_report.ui.view.DAILY_QUERIES
import com.matheuskittler.weather_report.ui.view.FORECAST_DAYS
import com.matheuskittler.weather_report.ui.view.HOURLY_QUERIES
import com.matheuskittler.weather_report.ui.view.MainViewModel
import com.matheuskittler.weather_report.ui.view.TIME_ZONE
import com.matheuskittler.weather_report.utils.Utils


@Composable
fun BackgroundMode(viewModel: MainViewModel, isLoading: State<Boolean>) {

    val locationState by viewModel.location.observeAsState()

    Scaffold { padding ->
        if (isLoading.value) {
            LoadingIndicator()
        } else {
            Column(
                modifier = Modifier.padding(padding)
            ) {
                // Se a localização não for nula, exiba os dados na tela
                locationState?.let { location ->
                    val context = LocalContext.current
                    TextFieldLocation(context = context, onSearch = { query ->
                        val coordinates = Utils.getLocationFromAddress(context, query)
                        coordinates?.let { location ->
                            // Aqui você pode usar as coordenadas para buscar os dados meteorológicos
                            val latitude = location.latitude
                            val longitude = location.longitude
                            viewModel.fetchWeatherData(
                                "$latitude",
                                "$longitude",
                                FORECAST_DAYS,
                                CURRENT_QUERIES,
                                TIME_ZONE,
                                HOURLY_QUERIES,
                                DAILY_QUERIES
                            )
                        }
                    })
                    Row(
                        modifier = Modifier.padding(start = 15.dp, end = 15.dp)
                    ) {
                        Column {
                            Text(
                                text = "Previsão do tempo de hora em hora",
                                color = Color.Black,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.padding(top = 2.dp))
                            WeatherList(
                                times = location.hourly.time,
                                temperatures = location.hourly.temperature
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(25.dp)
                    ) {
                        CurrentTemperature(location)
                    }
                    Text(
                        text = "Previsão para 7 dias",
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.padding(top = 2.dp))
                    ListHorizontal(
                        times = location.hourly.time,
                        temperatures = location.hourly.temperature
                    )
                }
            }
        }
    }
}