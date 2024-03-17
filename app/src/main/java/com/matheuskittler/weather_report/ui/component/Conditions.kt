package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import java.nio.file.WatchEvent

@Composable
fun Conditions(
    text: String,
    info: String,
    changeColor: Boolean
) {

    val backgroundColor: Color = MaterialTheme.colorScheme.onPrimary
    val textColor: Color = Color.Black
    when (changeColor) {
        true -> {
            MaterialTheme.colorScheme.onBackground
        }

        false -> {
            MaterialTheme.colorScheme.onPrimary
        }
    }

    Column (
        modifier = Modifier
            .wrapContentSize()
            .clip(shape = MaterialTheme.shapes.medium)
    ) {
        Box(
            modifier = Modifier
                .background(color = backgroundColor)
                .padding(10.dp),
        ) {
            Row {
                Column(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Row {
                        Text(text = text, color = textColor)
                    }
                    Row {
                        Text(text = info)
                    }

                }
                Spacer(modifier = Modifier.padding(start = 12.dp))
                Column(
                    verticalArrangement = Arrangement.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null,
                        tint = textColor,
                        modifier = Modifier.wrapContentSize()
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
        Conditions("Umidade", "88%", true)
    }
}