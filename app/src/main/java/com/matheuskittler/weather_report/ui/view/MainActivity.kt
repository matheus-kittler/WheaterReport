package com.matheuskittler.weather_report.ui.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import android.location.Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.location.LocationServices
import com.matheuskittler.weather_report.service.ApiService.createWeatherAPI
import com.matheuskittler.weather_report.service.FakeAPI
import com.matheuskittler.weather_report.ui.component.CurrentTemperature
import com.matheuskittler.weather_report.ui.component.ListHorizontal
import com.matheuskittler.weather_report.ui.component.LoadingIndicator
import com.matheuskittler.weather_report.ui.component.TextFieldLocation
import com.matheuskittler.weather_report.ui.component.WeatherList
import com.matheuskittler.weather_report.ui.theme.BackgroundMode
import com.matheuskittler.weather_report.utils.Utils

const val FORECAST_DAYS = 7
const val TIME_ZONE = "America/Sao_Paulo"

val HOURLY_QUERIES = listOf(
    "temperature",
    "precipitation_probability",
    "relative_humidity_2m"
)

val DAILY_QUERIES = listOf(
    "uv_index_max",
    "temperature_2m_max",
    "temperature_2m_min",
    "sunrise",
    "sunset"
)

val CURRENT_QUERIES = listOf(
    "temperature",
    "relative_humidity_2m",
    "uv_index",
    "is_day"
)

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel
    val isLoading: MutableState<Boolean> = mutableStateOf(true)


    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        getLastKnownLocation()

    }

    private fun getLastKnownLocation() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        if (isLocationPermissionGranted()) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    location?.let { onLocationObtained(it) }
                }
                .addOnFailureListener { e ->
                    e.printStackTrace()
                }
        } else {
            // Se a permissão ainda não foi concedida, solicitar permissão de localização
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }


    private fun onLocationObtained(location: Location) {
        val latitude = location.latitude
        val longitude = location.longitude
        viewModel.fetchWeatherData(
            "$latitude",
            "$longitude",
            FORECAST_DAYS,
            CURRENT_QUERIES,
            TIME_ZONE,
            HOURLY_QUERIES,
            DAILY_QUERIES
        )
        viewModel.location.observe(this) {
            setContent {
                val isLoading = viewModel.isLoading.collectAsState()
                BackgroundMode(viewModel = viewModel, isLoading)
            }
        }
    }

    private fun isLocationPermissionGranted(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permissão de localização concedida, tentar obter a localização novamente
            getLastKnownLocation()
        } else {
            // Permissão de localização negada, lidar com isso conforme necessário
        }
    }


    private fun init() {
        val weatherAPI =
            createWeatherAPI()
        val viewModelFactory = MainViewModelFactory(weatherAPI)
        isLoading.value = true
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}

@Composable
fun LoadingIndicator() {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = Color.Black,
            modifier = Modifier.wrapContentSize(),
        )
    }
}

@Preview
@Composable
fun GreetingPreview() {
    val viewModel = MainViewModel(FakeAPI())
    val isLoading = remember { mutableStateOf(false) }
//    BackgroundMode(viewModel = viewModel, isLoading)
    LoadingIndicator()
}