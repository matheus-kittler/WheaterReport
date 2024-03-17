package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowScrollHorizontal(
    changeColor: Boolean
) {

    val color: Color = if (changeColor) {
        MaterialTheme.colorScheme.onBackground
    } else {
        MaterialTheme.colorScheme.onPrimary
    }

    Column(
        modifier = Modifier.fillMaxWidth().clip(shape = MaterialTheme.shapes.medium)
    ) {
        Box(
            modifier = Modifier
                .background(color = color)
                .fillMaxWidth()

        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(7) {
                    Box (
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    ) {
                        RowHorizontalComponent(changeColor = changeColor)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RowScrollHorizontalPreview() {
    MaterialTheme {
        RowScrollHorizontal(changeColor = false)
    }
}