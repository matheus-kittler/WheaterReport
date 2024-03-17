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


@Composable
fun RowHorizontalComponent(
    changeColor: Boolean
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
        Text(text = "27°", color = color, fontSize = 16.sp)
        Spacer(modifier = Modifier.size(15.dp))
        Icon(
            imageVector = Icons.Rounded.Favorite,
            contentDescription = null,
            tint = color,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "Segunda-feira", color = color, fontSize = 10.sp)

    }

}

@Preview
@Composable
private fun RowHorizontalComponentPreview() {
    MaterialTheme {
        RowHorizontalComponent(changeColor = true)
    }
}