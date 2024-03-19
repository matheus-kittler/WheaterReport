package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Hourly
import com.matheuskittler.weather_report.model.HourlyUnits
import com.matheuskittler.weather_report.model.Location
import retrofit2.Response

class FakeAPI : IWeatherAPI {
    override suspend fun getWeatherReport(
        latitude: String,
        longitude: String,
        forecastDays: Int,
        temperature: String,
        hourly: String
    ): Response<Location> {
        val fakeLocation = Location(
            latitude = "-30.0",
            longitude = "-51.0",
            genTimeMs = "0.02396106719970703",
            utcSeconds = "0",
            timezone = "GMT",
            timezoneAbbreviation = "GMT",
            elevation = "37.0",
            hourlyUnits = HourlyUnits("Celsius", "ºC"),
            hourly = Hourly(
                listOf("12:00 PM", "1:00 PM", "2:00 PM"),
                listOf(16.2, 12.9),
                listOf(0.00, 00.1, 00.0),
                listOf(19, 23, 28),
                listOf(19, 23, 28),
            )
        )

        // Encapsula a Location fictícia em um Response simulado com sucesso (código 200)
        return Response.success(fakeLocation)
    }
}