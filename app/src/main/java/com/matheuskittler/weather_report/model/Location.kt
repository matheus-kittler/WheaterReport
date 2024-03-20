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
    val current: CurrentWeather = CurrentWeather("", 0, 0.0, "", "", 1),
    @SerializedName("current_units")
    val currentUnits: CurrentUnits = CurrentUnits("", "", "", "", "", ""),
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits = HourlyUnits("", ""),
    val hourly: Hourly = Hourly(listOf(), listOf(), listOf(), listOf(), listOf()),
    val daily: Daily = Daily(listOf(), listOf(), listOf(), listOf(), listOf(), listOf()),
)

data class HourlyUnits(
    val time: String,
    @SerializedName("temperature_2m")
    val temperature: String
)

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature")
    val temperature: List<Double>,
    val precipitation: List<Double>,
    @SerializedName("precipitation_probability")
    val probability: List<Int>,
    @SerializedName("relative_humidity_2m")
    val humidity: List<Int>
)

data class Daily(
    val time: List<String>,
    @SerializedName("uv_index_max")
    val uvIndex: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    @SerializedName("temperature_2m_max")
    val maxTemperature: List<Double>,
    @SerializedName("temperature_2m_min")
    val minTemperature: List<Double>
)

data class CurrentWeather(
    val time: String,
    val interval: Int,
    val temperature: Double,
    @SerializedName("relative_humidity_2m")
    val humidity: String,
    @SerializedName("uv_index")
    val uvIndex: String,
    @SerializedName("is_day")
    val dayNight: Int,
)

data class CurrentUnits(
    val time: String,
    val interval: String,
    val temperature: String,
    @SerializedName("relative_humidity_2m")
    val humidityPercentage: String,
    @SerializedName("uv_index")
    val uvIndex: String?,
    @SerializedName("is_day")
    val dayNight: String?,
)