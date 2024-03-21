package com.matheuskittler.weather_report.ui.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import android.location.Location
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.LocationServices
import com.matheuskittler.weather_report.service.AppDispatcher
import com.matheuskittler.weather_report.service.FakeAPI
import com.matheuskittler.weather_report.service.IWeatherService
import com.matheuskittler.weather_report.ui.theme.BackgroundMode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.android.ext.android.inject
import kotlin.coroutines.CoroutineContext

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

    private val viewModel: MainViewModel by inject()
    val isLoading: MutableState<Boolean> = mutableStateOf(true)


    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
            getLastKnownLocation()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }
}

@Preview
@Composable
fun GreetingPreview() {
    val viewModel = MainViewModel(object : IWeatherService {
        override suspend fun getWeatherData(
            latitude: String,
            longitude: String,
            forecastDays: Int,
            current: List<String>,
            timezone: String,
            hourly: List<String>,
            daily: List<String>
        ): Flow<com.matheuskittler.weather_report.model.Location> {
            return flow {  }
        }

    },object : AppDispatcher {
        override var main: CoroutineContext = Dispatchers.Unconfined
        override var io: CoroutineContext = Dispatchers.Unconfined
    })
    val isLoading = remember { mutableStateOf(false) }
    BackgroundMode(viewModel = viewModel, isLoading)
}