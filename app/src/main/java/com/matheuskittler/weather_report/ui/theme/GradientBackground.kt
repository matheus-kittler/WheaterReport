package com.matheuskittler.weather_report.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.ui.component.Conditions
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.RowScrollHorizontal
import com.matheuskittler.weather_report.ui.component.TextFieldLocation

@Composable
fun BackgroundMode() {
    val location by remember { mutableStateOf<Location?>(null) }
    val context = LocalContext.current
    Scaffold { padding ->
        if (location != null) {
            Column(
                modifier = Modifier.padding(padding)
            ) {
                TextFieldLocation(
                    onSearch = { query ->
                        // Lógica de pesquisa com a query
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Column {
                        Text(
                            text = "Previsão do tempo de hora em hora",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.padding(top = 2.dp))
                        RowScrollHorizontal(false, location!!)
                    }
                }
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    CurrentTemperature(location?.hourly?.temperature?.get(0) ?: 0F,
                        location?.hourly?.time?.get(0) ?: "erro", "28 máxima", "21 minima")
                    Column(
                        modifier = Modifier.padding(start = 15.dp)
                    ) {
                        Conditions(text = "Umidade", info = "88%", false)
                        Spacer(modifier = Modifier.padding(8.dp))
                        Conditions(text = "índice UV", info = "0", false)
                    }
                }
                Row {
                    Column(
                        modifier = Modifier.padding(horizontal = 15.dp)
                    ) {
                        Text(text = "Previsão para 7 dias", color = Color.Black, fontSize = 14.sp)
                        Spacer(modifier = Modifier.padding(top = 2.dp))
                        RowScrollHorizontal(false, location!!)
                    }
                }
            }
        } else {
            Column {
                Text(text = "Erro")
            }
        }
    }
}

@Preview
@Composable
private fun GradientBackgroundPreview() {
    MaterialTheme {
        BackgroundMode(
//            Location(
//                "-30.0",
//                "-51.0",
//                "0.00095367431640625",
//                "0",
//                "GMT",
//                "GMT",
//                "37.0",
//                HourlyUnits(
//                    "iso8601",
//                    "°C",
//                ),
//                Hourly(listOf("'\"2024-03-17T00:00\",\n" +
//                        "                    \"2024-03-17T01:00\",\n" +
//                        "                    \"2024-03-17T02:00\",\n" +
//                        "                    \"2024-03-17T03:00\",\n" +
//                        "                    \"2024-03-17T04:00\",\n" +
//                        "                    \"2024-03-17T05:00\",\n" +
//                        "                    \"2024-03-17T06:00\",\n" +
//                        "                    \"2024-03-17T07:00\",\n" +
//                        "                    \"2024-03-17T08:00\",\n" +
//                        "                    \"2024-03-17T09:00\",\n" +
//                        "                    \"2024-03-17T10:00\",\n" +
//                        "                    \"2024-03-17T11:00\",\n" +
//                        "                    \"2024-03-17T12:00\",\n" +
//                        "                    \"2024-03-17T13:00\",\n" +
//                        "                    \"2024-03-17T14:00\",\n" +
//                        "                    \"2024-03-17T15:00\",\n" +
//                        "                    \"2024-03-17T16:00\",\n" +
//                        "                    \"2024-03-17T17:00\",\n" +
//                        "                    \"2024-03-17T18:00\",\n" +
//                        "                    \"2024-03-17T19:00\",\n" +
//                        "                    \"2024-03-17T20:00\",\n" +
//                        "                    \"2024-03-17T21:00\",\n" +
//                        "                    \"2024-03-17T22:00\",\n" +
//                        "                    \"2024-03-17T23:00\",\n" +
//                        "                    \"2024-03-18T00:00\",\n" +
//                        "                    \"2024-03-18T01:00\",\n" +
//                        "                    \"2024-03-18T02:00\",\n" +
//                        "                    \"2024-03-18T03:00\",\n" +
//                        "                    \"2024-03-18T04:00\",\n" +
//                        "                    \"2024-03-18T05:00\",\n" +
//                        "                    \"2024-03-18T06:00\",\n" +
//                        "                    \"2024-03-18T07:00\",\n" +
//                        "                    \"2024-03-18T08:00\",\n" +
//                        "                    \"2024-03-18T09:00\",\n" +
//                        "                    \"2024-03-18T10:00\",\n" +
//                        "                    \"2024-03-18T11:00\",\n" +
//                        "                    \"2024-03-18T12:00\",\n" +
//                        "                    \"2024-03-18T13:00\",\n" +
//                        "                    \"2024-03-18T14:00\",\n" +
//                        "                    \"2024-03-18T15:00\",\n" +
//                        "                    \"2024-03-18T16:00\",\n" +
//                        "                    \"2024-03-18T17:00\",\n" +
//                        "                    \"2024-03-18T18:00\",\n" +
//                        "                    \"2024-03-18T19:00\",\n" +
//                        "                    \"2024-03-18T20:00\",\n" +
//                        "                    \"2024-03-18T21:00\",\n" +
//                        "                    \"2024-03-18T22:00\",\n" +
//                        "                    \"2024-03-18T23:00\",\n" +
//                        "                    \"2024-03-19T00:00\",\n" +
//                        "                    \"2024-03-19T01:00\",\n" +
//                        "                    \"2024-03-19T02:00\",\n" +
//                        "                    \"2024-03-19T03:00\",\n" +
//                        "                    \"2024-03-19T04:00\",\n" +
//                        "                    \"2024-03-19T05:00\",\n" +
//                        "                    \"2024-03-19T06:00\",\n" +
//                        "                    \"2024-03-19T07:00\",\n" +
//                        "                    \"2024-03-19T08:00\",\n" +
//                        "                    \"2024-03-19T09:00\",\n" +
//                        "                    \"2024-03-19T10:00\",\n" +
//                        "                    \"2024-03-19T11:00\",\n" +
//                        "                    \"2024-03-19T12:00\",\n" +
//                        "                    \"2024-03-19T13:00\",\n" +
//                        "                    \"2024-03-19T14:00\",\n" +
//                        "                    \"2024-03-19T15:00\",\n" +
//                        "                    \"2024-03-19T16:00\",\n" +
//                        "                    \"2024-03-19T17:00\",\n" +
//                        "                    \"2024-03-19T18:00\",\n" +
//                        "                    \"2024-03-19T19:00\",\n" +
//                        "                    \"2024-03-19T20:00\",\n" +
//                        "                    \"2024-03-19T21:00\",\n" +
//                        "                    \"2024-03-19T22:00\",\n" +
//                        "                    \"2024-03-19T23:00\",\n" +
//                        "                    \"2024-03-20T00:00\",\n" +
//                        "                    \"2024-03-20T01:00\",\n" +
//                        "                    \"2024-03-20T02:00\",\n" +
//                        "                    \"2024-03-20T03:00\",\n" +
//                        "                    \"2024-03-20T04:00\",\n" +
//                        "                    \"2024-03-20T05:00\",\n" +
//                        "                    \"2024-03-20T06:00\",\n" +
//                        "                    \"2024-03-20T07:00\",\n" +
//                        "                    \"2024-03-20T08:00\",\n" +
//                        "                    \"2024-03-20T09:00\",\n" +
//                        "                    \"2024-03-20T10:00\",\n" +
//                        "                    \"2024-03-20T11:00\",\n" +
//                        "                    \"2024-03-20T12:00\",\n" +
//                        "                    \"2024-03-20T13:00\",\n" +
//                        "                    \"2024-03-20T14:00\",\n" +
//                        "                    \"2024-03-20T15:00\",\n" +
//                        "                    \"2024-03-20T16:00\",\n" +
//                        "                    \"2024-03-20T17:00\",\n" +
//                        "                    \"2024-03-20T18:00\",\n" +
//                        "                    \"2024-03-20T19:00\",\n" +
//                        "                    \"2024-03-20T20:00\",\n" +
//                        "                    \"2024-03-20T21:00\",\n" +
//                        "                    \"2024-03-20T22:00\",\n" +
//                        "                    \"2024-03-20T23:00\",\n" +
//                        "                    \"2024-03-21T00:00\",\n" +
//                        "                    \"2024-03-21T01:00\",\n" +
//                        "                    \"2024-03-21T02:00\",\n" +
//                        "                    \"2024-03-21T03:00\",\n" +
//                        "                    \"2024-03-21T04:00\",\n" +
//                        "                    \"2024-03-21T05:00\",\n" +
//                        "                    \"2024-03-21T06:00\",\n" +
//                        "                    \"2024-03-21T07:00\",\n" +
//                        "                    \"2024-03-21T08:00\",\n" +
//                        "                    \"2024-03-21T09:00\",\n" +
//                        "                    \"2024-03-21T10:00\",\n" +
//                        "                    \"2024-03-21T11:00\",\n" +
//                        "                    \"2024-03-21T12:00\",\n" +
//                        "                    \"2024-03-21T13:00\",\n" +
//                        "                    \"2024-03-21T14:00\",\n" +
//                        "                    \"2024-03-21T15:00\",\n" +
//                        "                    \"2024-03-21T16:00\",\n" +
//                        "                    \"2024-03-21T17:00\",\n" +
//                        "                    \"2024-03-21T18:00\",\n" +
//                        "                    \"2024-03-21T19:00\",\n" +
//                        "                    \"2024-03-21T20:00\",\n" +
//                        "                    \"2024-03-21T21:00\",\n" +
//                        "                    \"2024-03-21T22:00\",\n" +
//                        "                    \"2024-03-21T23:00\",\n" +
//                        "                    \"2024-03-22T00:00\",\n" +
//                        "                    \"2024-03-22T01:00\",\n" +
//                        "                    \"2024-03-22T02:00\",\n" +
//                        "                    \"2024-03-22T03:00\",\n" +
//                        "                    \"2024-03-22T04:00\",\n" +
//                        "                    \"2024-03-22T05:00\",\n" +
//                        "                    \"2024-03-22T06:00\",\n" +
//                        "                    \"2024-03-22T07:00\",\n" +
//                        "                    \"2024-03-22T08:00\",\n" +
//                        "                    \"2024-03-22T09:00\",\n" +
//                        "                    \"2024-03-22T10:00\",\n" +
//                        "                    \"2024-03-22T11:00\",\n" +
//                        "                    \"2024-03-22T12:00\",\n" +
//                        "                    \"2024-03-22T13:00\",\n" +
//                        "                    \"2024-03-22T14:00\",\n" +
//                        "                    \"2024-03-22T15:00\",\n" +
//                        "                    \"2024-03-22T16:00\",\n" +
//                        "                    \"2024-03-22T17:00\",\n" +
//                        "                    \"2024-03-22T18:00\",\n" +
//                        "                    \"2024-03-22T19:00\",\n" +
//                        "                    \"2024-03-22T20:00\",\n" +
//                        "                    \"2024-03-22T21:00\",\n" +
//                        "                    \"2024-03-22T22:00\",\n" +
//                        "                    \"2024-03-22T23:00\",\n" +
//                        "                    \"2024-03-23T00:00\",\n" +
//                        "                    \"2024-03-23T01:00\",\n" +
//                        "                    \"2024-03-23T02:00\",\n" +
//                        "                    \"2024-03-23T03:00\",\n" +
//                        "                    \"2024-03-23T04:00\",\n" +
//                        "                    \"2024-03-23T05:00\",\n" +
//                        "                    \"2024-03-23T06:00\",\n" +
//                        "                    \"2024-03-23T07:00\",\n" +
//                        "                    \"2024-03-23T08:00\",\n" +
//                        "                    \"2024-03-23T09:00\",\n" +
//                        "                    \"2024-03-23T10:00\",\n" +
//                        "                    \"2024-03-23T11:00\",\n" +
//                        "                    \"2024-03-23T12:00\",\n" +
//                        "                    \"2024-03-23T13:00\",\n" +
//                        "                    \"2024-03-23T14:00\",\n" +
//                        "                    \"2024-03-23T15:00\",\n" +
//                        "                    \"2024-03-23T16:00\",\n" +
//                        "                    \"2024-03-23T17:00\",\n" +
//                        "                    \"2024-03-23T18:00\",\n" +
//                        "                    \"2024-03-23T19:00\",\n" +
//                        "                    \"2024-03-23T20:00\",\n" +
//                        "                    \"2024-03-23T21:00\",\n" +
//                        "                    \"2024-03-23T22:00\",\n" +
//                        "                    \"2024-03-23T23:00\"'"), floatArrayOf(
//                    24.4F,
//                    24.0F,
//                    23.7F,
//                    23.5F,
//                    23.5F,
//                    23.5F,
//                    23.5F,
//                    23.4F,
//                    23.6F,
//                    23.6F,
//                    23.6F,
//                    24.2F,
//                    24.8F,
//                    25.3F,
//                    25.6F,
//                    26.1F,
//                    26.4F,
//                    26.9F,
//                    28.1F,
//                    28.3F,
//                    27.8F,
//                    26.9F,
//                    25.7F,
//                    25.1F,
//                    24.6F,
//                    23.8F,
//                    23.3F,
//                    23.1F,
//                    23.0F,
//                    22.9F,
//                    22.7F,
//                    22.7F,
//                    22.7F,
//                    22.5F,
//                    22.6F,
//                    23.8F,
//                    25.4F,
//                    27.2F,
//                    28.6F,
//                    30.0F,
//                    30.4F,
//                    30.6F,
//                    29.6F,
//                    28.4F,
//                    27.9F,
//                    27.2F,
//                    26.5F,
//                    26.0F,
//                    25.7F,
//                    25.4F,
//                    25.2F,
//                    25.0F,
//                    24.8F,
//                    24.7F,
//                    24.6F,
//                    24.6F,
//                    24.5F,
//                    24.4F,
//                    24.4F,
//                    24.6F,
//                    24.9F,
//                    25.1F,
//                    25.5F,
//                    25.9F,
//                    26.2F,
//                    26.5F,
//                    26.9F,
//                    26.8F,
//                    26.6F,
//                    26.4F,
//                    25.8F,
//                    25.1F,
//                    24.8F,
//                    24.6F,
//                    24.4F,
//                    24.2F,
//                    24.0F,
//                    23.9F,
//                    23.6F,
//                    23.3F,
//                    23.1F,
//                    23.0F,
//                    23.1F,
//                    25.0F,
//                    27.4F,
//                    29.3F,
//                    30.5F,
//                    31.5F,
//                    32.3F,
//                    32.9F,
//                    32.0F,
//                    31.3F,
//                    30.8F,
//                    30.4F,
//                    29.4F,
//                    28.5F,
//                    28.2F,
//                    27.9F,
//                    27.8F,
//                    27.6F,
//                    27.3F,
//                    26.9F,
//                    26.2F,
//                    24.9F,
//                    23.4F,
//                    22.3F,
//                    22.0F,
//                    22.1F,
//                    22.3F,
//                    22.5F,
//                    22.8F,
//                    22.8F,
//                    22.3F,
//                    21.5F,
//                    20.9F,
//                    20.5F,
//                    20.2F,
//                    20.0F,
//                    19.9F,
//                    19.8F,
//                    19.6F,
//                    19.3F,
//                    19.0F,
//                    18.5F,
//                    18.0F,
//                    17.3F,
//                    16.9F,
//                    16.5F,
//                    16.3F,
//                    16.5F,
//                    17.5F,
//                    18.9F,
//                    20.3F,
//                    21.4F,
//                    22.4F,
//                    23.3F,
//                    23.8F,
//                    24.1F,
//                    24.3F,
//                    23.5F,
//                    22.6F,
//                    21.6F,
//                    20.7F,
//                    19.8F,
//                    19.1F,
//                    18.9F,
//                    18.9F,
//                    18.8F,
//                    18.6F,
//                    18.3F,
//                    18.0F,
//                    17.4F,
//                    16.8F,
//                    16.8F,
//                    17.9F,
//                    19.5F,
//                    21.0F,
//                    22.3F,
//                    23.6F,
//                    24.6F,
//                    25.4F,
//                    25.9F,
//                    25.9F,
//                    25.2F,
//                    23.9F,
//                    22.6F,
//                    21.6F,
//                    20.6F)
//                ),
//            )
        )
    }
}
