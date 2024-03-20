package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.CurrentUnits
import com.matheuskittler.weather_report.model.CurrentWeather
import com.matheuskittler.weather_report.model.Daily
import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location
import retrofit2.Response

class FakeAPI : IWeatherAPI {
    override suspend fun getWeatherReport(
        latitude: String,
        longitude: String,
        forecastDays: Int,
        current: List<String>,
        timezone: String,
        hourly: List<String>,
        daily: List<String>,
    ): Response<Location> {
        val fakeLocation = Location(
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

        // Encapsula a Location fictícia em um Response simulado com sucesso (código 200)
        return Response.success(fakeLocation)
    }
}