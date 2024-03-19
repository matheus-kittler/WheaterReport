package com.matheuskittler.weather_report.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale


data class Location(
    val latitude: String,
    val longitude: String,
    @SerializedName("generationtime_ms")
    val genTimeMs: String,
    @SerializedName("utc_offset_seconds")
    val utcSeconds: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: String,
    val hourlyUnits: HourlyUnits = HourlyUnits("", ""),
    val hourly: Hourly = Hourly(listOf(), listOf(), listOf(), listOf(), listOf()),
)

data class HourlyUnits(
    val time: String,
    @SerializedName("temperature_2m")
    val temperature: String
)

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperature: List<Double>,
    val precipitation: List<Double>,
    @SerializedName("precipitation_probability")
    val probability: List<Int>,
    @SerializedName("relative_humidity_2m")
    val humidity: List<Int>
) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val locale = Locale.getDefault()

    fun convertTimeToDayOfWeek(): List<String> {
        val dayOfWeekList = mutableListOf<String>()
        for (date in time) {
            val dateTime = LocalDateTime.parse(date, formatter)
            val dayOfWeek = dateTime.dayOfWeek.getDisplayName(TextStyle.FULL, locale)
            dayOfWeekList.add(dayOfWeek)
        }
        return dayOfWeekList
    }
}
