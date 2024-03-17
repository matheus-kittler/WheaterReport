package com.matheuskittler.weather_report.model

import com.google.gson.annotations.SerializedName

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
    val hourlyUnits: String
//    HourlyUnits
    ,
    val hourly: String
//    Hourly
    ,
)

data class HourlyUnits(
    val time: String,
    @SerializedName("temperature_2m")
    val temperature: String
)

data class Hourly(
    val time: List<String>,
    @SerializedName("temperature_2m")
    val temperature: List<Float>
)
