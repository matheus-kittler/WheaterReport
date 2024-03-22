package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.R
import com.matheuskittler.weather_report.model.CurrentWeather
import com.matheuskittler.weather_report.model.Daily
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.utils.Utils.formatCurrentDay
import com.matheuskittler.weather_report.utils.Utils.formatTemperature
import com.matheuskittler.weather_report.utils.Utils.getMaxAndMinTemperatureForCurrentDay

@Composable
fun CurrentTemperature(location: Location) {
    val (maxTemperature, minTemperature) = getMaxAndMinTemperatureForCurrentDay(location)
    val formattedMaxTemperature = maxTemperature?.let { formatTemperature(it) }
    val formattedMinTemperature = minTemperature?.let { formatTemperature(it) }
    Row {
        Column(
            modifier = Modifier.wrapContentSize(),
        ) {
            Text(
                text = formatCurrentDay(location.current.time),
                color = Color.Black,
                fontSize = 16.sp
            )
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = formatTemperature(location.current.temperature),
                    color = Color.Black,
                    fontSize = 59.sp
                )
            }
            Row {
                Text(
                    text = "${formattedMaxTemperature} - ${formattedMinTemperature}",
                    color = Color.Black,
                    fontSize = 12.sp
                )
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Conditions(text = stringResource(R.string.text_humidity), info = "${location.current.humidity}%")
            Spacer(modifier = Modifier.padding(10.dp))
            Conditions(text = stringResource(R.string.text_uv_index), info = location.current.uvIndex)
        }
    }
}

@Preview
@Composable
private fun CurrentTemperaturePreview() {
    MaterialTheme {
        CurrentTemperature(
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
                ),
                current = CurrentWeather(
                    "2024-03-20T09:39",
                    0,
                    0.0,
                    "",
                    "",
                    1
                ),
                daily = Daily(
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(),
                    listOf(28.9),
                    listOf(29.0),
                )
            )
        )
    }
}