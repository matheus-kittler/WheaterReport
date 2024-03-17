package com.matheuskittler.weather_report.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.ui.component.ColumnScrollVertical
import com.matheuskittler.weather_report.ui.component.Conditions
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.RowScrollHorizontal
import com.matheuskittler.weather_report.ui.component.TextFieldLocation
import com.matheuskittler.weather_report.ui.theme.BackgroundMode
import com.matheuskittler.weather_report.ui.theme.WeatherReportTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                BackgroundMode()
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    BackgroundMode()
}