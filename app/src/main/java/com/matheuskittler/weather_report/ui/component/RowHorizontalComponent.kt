package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location


@Composable
fun RowHorizontalComponent(
    changeColor: Boolean,
    location: Location
) {


    val color: Color = if (changeColor) {
        Color.White
    } else {
        Color.Black
    }

    Column(
        Modifier.padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${location.hourly.temperature[0]}ºC", color = color, fontSize = 16.sp)
        Spacer(modifier = Modifier.size(15.dp))
        Icon(
            imageVector = Icons.Rounded.Favorite,
            contentDescription = null,
            tint = color,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "", color = color, fontSize = 10.sp)

    }

}

@Preview
@Composable
private fun RowHorizontalComponentPreview() {
    MaterialTheme {
        RowHorizontalComponent(changeColor = false, location =  Location(
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
                listOf(19, 23, 28),
            )
        ))
    }
}