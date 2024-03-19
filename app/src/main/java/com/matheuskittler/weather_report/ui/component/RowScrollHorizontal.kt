package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location

@Composable
fun RowScrollHorizontal(
    changeColor: Boolean,
    location: Location
) {

    val color: Color = if (changeColor) {
        MaterialTheme.colorScheme.onBackground
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = MaterialTheme.shapes.medium)
    ) {
        Box(
            modifier = Modifier
                .background(color = color)
                .fillMaxWidth()

        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(7) {
                    Box(
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        RowHorizontalComponent(changeColor = changeColor, location)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RowScrollHorizontalPreview() {
    MaterialTheme {
        RowScrollHorizontal(
            changeColor = false,
            location = Location(
                latitude = "-30.0",
                longitude = "-51.0",
                genTimeMs = "0.02396106719970703",
                utcSeconds = "0",
                timezone = "GMT",
                timezoneAbbreviation = "GMT",
                elevation = "37.0",
                hourlyUnits = HourlyUnits("Celsius", "ºC"),
                hourly = Hourly(
                    listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                    listOf(16.2, 12.9),
                    listOf(0.00, 00.1, 00.0),
                    listOf(19, 23, 28),
                    listOf(19, 23, 28)
                )
            ),
        )
    }
}