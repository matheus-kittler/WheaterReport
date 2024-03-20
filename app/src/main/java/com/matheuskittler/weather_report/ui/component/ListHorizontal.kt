package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuskittler.weather_report.utils.Utils.formatTemperature

@Composable
fun ListHorizontal(
    times: List<String>, temperatures: List<Double>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(times) { index, time ->
            val temperature = temperatures.getOrNull(index)
            if (temperature != null) {
                RowHorizontalComponent(time = time, temperature = formatTemperature(temperature))
            }
        }
    }
}

@Preview
@Composable
private fun RowScrollHorizontalPreview() {
    MaterialTheme {
        ListHorizontal(
            times = listOf("2024-03-19T00:00", "2024-03-20T01:00", "2024-03-21T02:00"),
            temperatures = listOf(28.9, 20.9, 17.8)
        )
    }
}