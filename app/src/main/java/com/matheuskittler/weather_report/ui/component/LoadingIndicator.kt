package com.matheuskittler.weather_report.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator(
        color = Color.Black,
        modifier = Modifier.fillMaxSize()
    )
}