package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
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

@Composable
fun RowHorizontalComponent(
    time: String, temperature: String
) {

    Box (
        modifier = Modifier.background(Color.Red)
//            .background() TODO colocar adaptavel a cor com o dia/noite, sol/chuva
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .wrapContentSize()
                .clip(shape = MaterialTheme.shapes.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = time,
                fontSize = 9.sp,
                modifier = Modifier
                    .padding(5.dp)
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
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(5.dp)
            )
        }
    }
}

@Preview
@Composable
private fun RowHorizontalComponentPreview() {
    MaterialTheme {
        RowHorizontalComponent(time = "wendsday", temperature = "28°C")
    }
}