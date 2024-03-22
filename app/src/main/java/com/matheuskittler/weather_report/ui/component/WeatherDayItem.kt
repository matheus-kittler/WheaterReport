package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.utils.Utils

@Composable
fun WeatherDayItem(
    time: String, temperatureMax: String, temperatureMin: String
) {

    Box {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .wrapContentSize()
                .clip(shape = MaterialTheme.shapes.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = Utils.formatDateToDay(time),
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(15.dp)
            )

            Text(
                text = "Max $temperatureMax - Min $temperatureMin",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(15.dp)
            )
        }
    }
}

@Preview
@Composable
private fun WeatherDayListItemPreview() {
    MaterialTheme {
        WeatherDayItem(time = "wendsday", temperatureMax = "28°C", temperatureMin = "18°C")
    }
}