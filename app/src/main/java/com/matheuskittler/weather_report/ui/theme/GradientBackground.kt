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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.matheuskittler.weather_report.ui.component.Conditions
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.RowScrollHorizontal
import com.matheuskittler.weather_report.ui.component.TextFieldLocation

@Composable
fun BackgroundMode() {
    Scaffold { padding ->
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
                    Text(text = "Previsão do tempo de hora em hora", color = Color.Black, fontSize = 14.sp)
                    Spacer(modifier = Modifier.padding(top = 2.dp))
                    RowScrollHorizontal(false)
                }
            }
            Row(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                CurrentTemperature("27", "Agora", "28 máxima", "21 minima")
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
                    RowScrollHorizontal(false)
                }
            }
        }
    }
}

@Preview
@Composable
private fun GradientBackgroundPreview() {
    MaterialTheme {
        BackgroundMode()
    }
}
