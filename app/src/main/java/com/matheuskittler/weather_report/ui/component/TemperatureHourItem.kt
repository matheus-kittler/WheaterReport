package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.utils.Utils.formatDateToHour

@Composable
fun TemperatureHourItem(time: String, temperature: String) {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .wrapContentSize()
            .background(color = MaterialTheme.colorScheme.onTertiary)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatDateToHour(time),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(15.dp)
        )

        Text(
            text = temperature,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(15.dp)
        )
    }
}

@Preview
@Composable
fun DayWeatherItemPreview() {
    TemperatureHourItem(time = "wendsday", temperature = "28°C")
}