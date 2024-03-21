package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.R


@Composable
fun TextTitle(
    text: String,
) {
   Row(
       modifier = Modifier.padding(16.dp)
   ) {
       Text(
           text = text, color = Color.Black,
           fontSize = 18.sp
       )
   }
}

@Preview
@Composable
private fun ConditionsPreview() {
    MaterialTheme {
        TextTitle(text = stringResource(R.string.text_weather_report_day))
    }
}