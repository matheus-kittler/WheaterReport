package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.utils.Utils.convTimeToDayOfWeek

@Composable
fun DayWeatherRow(time: String, temperature: String) {
    // Seu código para exibir as informações relacionadas ao tempo (time) aqui
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .wrapContentSize()
//            .background() TODO colocar adaptavel a cor com o dia/noite, sol/chuva
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = convTimeToDayOfWeek(time),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(15.dp)
        )
        Icon(
            imageVector = Icons.Rounded.Favorite,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .padding(16.dp)
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
    DayWeatherRow(time = "wendsday", temperature = "28°C")
}