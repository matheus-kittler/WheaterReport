package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.matheuskittler.weather_report.utils.Utils.formatTemperature

@Composable
fun DayWeatherList(times: List<String>, temperatures: List<Double>) {
    LazyRow(
        modifier = Modifier
            .clip(shape = MaterialTheme.shapes.medium)
            .background(Color.Red)
    ) {
        itemsIndexed(times) { index, time ->
            val temperature = temperatures.getOrNull(index)
            if (temperature != null) {
                DayWeatherRow(
                    time = time,
                    temperature = formatTemperature(temperature)
                )
            }
        }
    }
}

@Preview
@Composable
fun WeatherListPreview() {
    DayWeatherList(
        times = listOf("2024-03-19T00:00", "2024-03-20T01:00", "2024-03-21T02:00"),
        temperatures = listOf(28.9, 20.9, 17.8)
    )
}