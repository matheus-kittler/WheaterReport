package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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

@Composable
fun CurrentTemperature(temperature: String, time: String, max: String, min: String) {

    Column(
        modifier = Modifier.wrapContentSize(),
    ) {
        Text(text = time, color = Color.Black, fontSize = 19.sp)
        Row(
          verticalAlignment = Alignment.Bottom
        ) {
            Text(text = temperature, color = Color.Black, fontSize = 65.sp)
            Icon(
                imageVector = Icons.Rounded.Favorite,
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.padding(8.dp).size(40.dp)
            )
        }
        Row {
            Text(text = "$max - $min", color = Color.Black, fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
private fun CurrentTemperaturePreview() {
    MaterialTheme {
        CurrentTemperature("27", "12:00", "20", "12")
    }
}