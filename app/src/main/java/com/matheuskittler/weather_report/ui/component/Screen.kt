package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.matheuskittler.weather_report.R
import com.matheuskittler.weather_report.ui.view.CURRENT_QUERIES
import com.matheuskittler.weather_report.ui.view.DAILY_QUERIES
import com.matheuskittler.weather_report.ui.view.FORECAST_DAYS
import com.matheuskittler.weather_report.ui.view.HOURLY_QUERIES
import com.matheuskittler.weather_report.ui.view.MainViewModel
import com.matheuskittler.weather_report.ui.view.TIME_ZONE
import com.matheuskittler.weather_report.utils.Utils

@Composable
fun Screen(viewModel: MainViewModel, isLoading: MutableState<Boolean>) {

    val locationState by viewModel.location.observeAsState()


    Scaffold { padding ->
        if (isLoading.value) {
            LoadingIndicator()
        } else {
            Column {
                locationState?.let { location ->
                    val context = LocalContext.current
                    TextFieldLocation(context = context, onSearch = { query ->
                        isLoading.value = true
                        val coordinates = Utils.getLocationFromAddress(context, query)
                        coordinates?.let { location ->
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
                            TextTitle(text = stringResource(R.string.text_weather_report_hour))
                            Spacer(modifier = Modifier.padding(top = 2.dp))
                            TemperatureHourList(
                                times = Utils.filterTimes(location.hourly.time),
                                temperatures = location.hourly.temperature
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.padding(25.dp)
                    ) {
                        CurrentTemperature(location)
                    }
                    TextTitle(text = stringResource(R.string.text_weather_report_day))
                    Spacer(modifier = Modifier.padding(top = 2.dp))
                    WeatherDayList(
                        times = location.daily.time,
                        temperaturesMax = location.daily.maxTemperature,
                        temperaturesMin = location.daily.minTemperature
                    )
                }
            }
        }
    }
}