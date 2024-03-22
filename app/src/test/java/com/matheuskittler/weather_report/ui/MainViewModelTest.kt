package com.matheuskittler.weather_report.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.matheuskittler.weather_report.model.CurrentUnits
import com.matheuskittler.weather_report.model.CurrentWeather
import com.matheuskittler.weather_report.model.Daily
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location
import com.matheuskittler.weather_report.service.AppDispatcher
import com.matheuskittler.weather_report.service.IWeatherService
import com.matheuskittler.weather_report.ui.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.coroutines.CoroutineContext


class MainViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var sut: MainViewModel
    private val dispatcher = StandardTestDispatcher()
    private var onRequest: (() -> Location)? = null
    private var onStartRequest: (() -> Unit)? = null

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        sut = MainViewModel(object : IWeatherService {
            override suspend fun getWeatherData(
                latitude: String,
                longitude: String,
                forecastDays: Int,
                current: List<String>,
                timezone: String,
                hourly: List<String>,
                daily: List<String>
            ): Flow<Location> {
                return flow {
                    onStartRequest?.invoke()
                    val response = onRequest?.invoke() ?: return@flow
                    emit(response)
                }
            }
        }, object : AppDispatcher {
            override var main: CoroutineContext = Dispatchers.Unconfined
            override var io: CoroutineContext = Dispatchers.Unconfined
        })
    }

    @Test
    fun `Testing weather data with valid arguments should return Success`() {
        val lat: String = "30"
        val lon: String = "40"
        val forecast: Int = 7
        val current: List<String> = listOf()
        val timeZone: String = ""
        val hourly: List<String> = listOf()
        val daily: List<String> = listOf()
        val result: Location = Location(
            latitude = "-30.0",
            longitude = "-51.0",
            genTimeMs = "0.02396106719970703",
            utcSeconds = "0",
            timezone = "GMT",
            timezoneAbbreviation = "GMT",
            elevation = "37.0",
            current = CurrentWeather("", 0, 0.0, "", "", 1),
            currentUnits = CurrentUnits("", "", "", "", "", ""),
            hourlyUnits = HourlyUnits("Celsius", "ºC"),
            hourly = Hourly(
                listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                listOf(16.2, 12.9),
                listOf(0.00, 00.1, 00.0),
                listOf(19, 23, 28),
                listOf(19, 23, 28),
            ),
            daily = Daily(
                listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                listOf(16.2, 12.9),
                listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                listOf(
                    36.4,
                    27.6,
                    25.3,
                    27.6,
                    29.1,
                    27.6,
                    26.3
                ),
                listOf(
                    21.8,
                    20.3,
                    17.3,
                    15.4,
                    16.3,
                    18.8,
                    18.5
                ),
            )
        )


        onStartRequest = {
            assert(sut.isLoading.value == true) {
                return@assert "service deveria estar carregando"
            }
        }
        onRequest = request@ {
            return@request result
        }
        sut.fetchWeatherData(lat, lon, forecast, current, timeZone, hourly, daily)
        assert(sut.isLoading.value == false) {
            return@assert "service já deveria ter parado de carregar"
        }
        assert(sut.errorText.value == null) {
            return@assert "não é para ter erro"
        }
        assert(sut.location.value == result) { // Esse é o erro
            return@assert "deu errado"
        }
    }


}
