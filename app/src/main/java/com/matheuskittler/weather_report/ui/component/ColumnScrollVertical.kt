package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
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
fun ColumnScrollVertical() {



    LazyColumn {
        items(7) { days ->
            Row (
                Modifier
                    .background(Color.Black)
                    .fillMaxSize()
                    .padding(start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
                
            ) {
                Text(text = "$days",  color = Color.White, fontSize = 19.sp)
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Text(text = "70%",  color = Color.White, fontSize = 19.sp)
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.wrapContentSize()
                )
                Spacer(modifier = Modifier.padding(end = 10.dp))
                Text(text = "29/27",  color = Color.White, fontSize = 19.sp)
            }
            Spacer(modifier = Modifier.padding(top = 3.dp))
        }
    }
}

@Preview
@Composable
private fun ColumnScrollVerticalPreview() {
    MaterialTheme {
        ColumnScrollVertical()
    }
}