package com.matheuskittler.weather_report.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class Location(
    val latitude: String = "",
    val longitude: String = "",
    @SerializedName("generationtime_ms")
    val genTimeMs: String = "",
    @SerializedName("utc_offset_seconds")
    val utcSeconds: String = "",
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String = "",
    val elevation: String = "",
    val hourlyUnits: HourlyUnits = HourlyUnits("", ""),
    val hourly: Hourly = Hourly(listOf(), floatArrayOf()),
)

data class HourlyUnits(
    val time: String,
    @SerializedName("temperature_2m")
    val temperature: String
)

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperature: FloatArray
) {
    val date = LocalDateTime.parse(time[Int.MAX_VALUE])
}
