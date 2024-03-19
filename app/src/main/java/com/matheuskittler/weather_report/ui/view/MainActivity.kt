package com.matheuskittler.weather_report.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.service.ApiService.createWeatherAPI
import com.matheuskittler.weather_report.service.FakeAPI
import com.matheuskittler.weather_report.service.IWeatherAPI
import com.matheuskittler.weather_report.service.WeatherService
import com.matheuskittler.weather_report.ui.component.Conditions
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.RowScrollHorizontal
import com.matheuskittler.weather_report.ui.component.TextFieldLocation
import com.matheuskittler.weather_report.utils.convertTimeToDayOfWeek
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        viewModel.fetchWeatherData("-29.9422", "-50.9928", 7, "temperature_2m", "temperature_2m")
        viewModel.location.observe(this, { location ->
            setContent {
                BackgroundMode(viewModel = viewModel)
            }
        })
    }

    private fun init() {
        val weatherAPI = createWeatherAPI() // Supondo que você tenha uma função para criar IWeatherAPI
        val viewModelFactory = MainViewModelFactory(weatherAPI)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

}

@Composable
fun BackgroundMode(viewModel: MainViewModel) {
//    val location by remember { mutableStateOf<Location?>(null) }

    // Observa o estado da localização na ViewModel
    val locationState by viewModel.location.observeAsState()

    // Atualiza o estado da localização quando os dados da API são recebidos
//    LaunchedEffect(viewModel.location) {
//        viewModel.location.collection { newLocation ->
//            location = newLocation
//        }
//    }

    // UI
    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            // Se a localização não for nula, exiba os dados na tela
            locationState?.let { location ->
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
                        RowScrollHorizontal(false, location)
                    }
                }
                Row(
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    val temperature = location.hourly.temperature
                    val time = convertTimeToDayOfWeek(location.hourly.time)

                    CurrentTemperature(
                        temperature,
                        time, "28 máxima", "21 minima"
                    )
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
                        Text(
                            text = "Previsão para 7 dias",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.padding(top = 2.dp))
                        RowScrollHorizontal(false, location)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    val viewModel = MainViewModel(FakeAPI())
    BackgroundMode(viewModel = viewModel)
}