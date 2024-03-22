package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuskittler.weather_report.utils.Utils.formatTemperature

@Composable
fun WeatherDayList(
    times: List<String>, temperaturesMax: List<Double>, temperaturesMin: List<Double>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(times) { index, time ->
            val temperatureMax = temperaturesMax.getOrNull(index)
            val temperatureMin = temperaturesMin.getOrNull(index)
            if (temperatureMax != null && temperatureMin != null) {
                WeatherDayItem(
                    time = time,
                    temperatureMax = formatTemperature(temperatureMax),
                    temperatureMin = formatTemperature(temperatureMin)
                )
            }
        }
    }
}

@Preview
@Composable
private fun WeatherDayListPreview() {
    MaterialTheme {
        WeatherDayList(
            times = listOf("2024-03-19T00:00", "2024-03-20T01:00", "2024-03-21T02:00"),
            temperaturesMax = listOf(28.9, 20.9, 17.8),
            temperaturesMin = listOf(18.9, 10.9, 7.8),
        )
    }
}