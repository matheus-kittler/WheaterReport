@file:Suppress("DEPRECATION")

package com.matheuskittler.weather_report.utils

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import com.matheuskittler.weather_report.model.Location
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.TextStyle
import java.util.Locale

object Utils {

    fun getLocationFromAddress(context: Context, address: String): LatLng? {
        val geocoder = Geocoder(context)
        try {
            val addresses = geocoder.getFromLocationName(address, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    val latitude = addresses[0].latitude
                    val longitude = addresses[0].longitude
                    return LatLng(latitude, longitude)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    fun formatDateToHour(timeText: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val dateTime = LocalDateTime.parse(timeText, formatter)
        val now = LocalDateTime.now()
        val tomorrow24h = now.toLocalDate().plusDays(1).atTime(LocalTime.of(23, 0))

        return if (dateTime.isAfter(now) && dateTime.isBefore(tomorrow24h)) {
            val hourFormatter = DateTimeFormatter.ofPattern("HH:mm")
            dateTime.format(hourFormatter)
        } else {
            ""
        }
    }

    fun filterTimes(times: List<String>): List<String> {
        val currentTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")

        return times.filter {
            val dateTime = LocalDateTime.parse(it, formatter)
            dateTime.isAfter(currentTime) && dateTime.isBefore(currentTime.plusHours(24))
        }
    }

    fun formatDateToDay(timeText: String): String {
        return try {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val date = LocalDate.parse(timeText, formatter)
            val dayOfMonth = date.dayOfMonth
            val month = date.monthValue
            String.format("%02d/%02d", dayOfMonth, month)
        } catch (e: DateTimeParseException) {
            "Data inválida"
        }
    }

    fun getMaxAndMinTemperatureForCurrentDay(location: Location): Pair<Double?, Double?> {
        val currentDay = location.current.time.substring(0, 10) // Extrair a data atual
        val index = location.daily.time.indexOfFirst { it == currentDay }

        if (index == -1) return Pair(null, null)
        return Pair(
            location.daily.maxTemperature.getOrNull(index),
            location.daily.minTemperature.getOrNull(index)
        )
    }

    fun formatCurrentDay(dateTimeString: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val dateTime = LocalDateTime.parse(dateTimeString, formatter)
        val currentDateTime = LocalDateTime.now()

        return if (dateTime.toLocalDate() == currentDateTime.toLocalDate()) {
            "Agora"
        } else {
            val dayOfWeek = dateTime.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault())
            dayOfWeek.substring(0, 1).uppercase(Locale.getDefault()) + dayOfWeek.substring(1)
        }
    }

    fun formatTemperature(temperature: Double): String {
        return "${Math.round(temperature)}°C"
    }
}