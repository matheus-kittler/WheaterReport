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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.R

@Composable
fun Conditions(
    text: String,
    info: String
) {
    val textColor: Color = Color.Black


    Column(
        modifier = Modifier
            .wrapContentSize()
            .clip(shape = MaterialTheme.shapes.medium)
    ) {
        Row {
            Column(
                modifier = Modifier.wrapContentSize()
            ) {
                Row {
                    Text(
                        text = text, color = textColor,
                        fontSize = 22.sp
                    )
                }
                Row {
                    Text(
                        text = info, color = textColor,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ConditionsPreview() {
    MaterialTheme {
        Conditions(
            stringResource(R.string.text_humidity),
            stringResource(R.string.text_info)
        )
    }
}