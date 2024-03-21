@file:Suppress("DEPRECATION")

package com.matheuskittler.weather_report.utils

import android.content.Context
import android.location.Geocoder
import com.google.android.gms.maps.model.LatLng
import com.matheuskittler.weather_report.model.Location
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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

    fun convTimeToDayOfWeek(timeText: String): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val dateTime = LocalDateTime.parse(timeText, formatter)
        val dayOfWeek = dateTime.dayOfWeek.toString()
        return dayOfWeek
    }

    fun getMaxAndMinTemperatureForCurrentDay(location: Location): Pair<Double?, Double?> {
        val currentDay = location.current.time.substring(0, 10) // Extrair a data atual

        // Encontrar o índice da data atual na lista de datas
        val index = location.daily.time.indexOfFirst { it == currentDay }

        // Se a data atual não for encontrada na lista de datas, retornar null para ambas as temperaturas
        if (index == -1) return Pair(null, null)

        // Retornar a temperatura máxima e mínima correspondentes à data atual
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
            // Capitalizar a primeira letra
            dayOfWeek.substring(0, 1).uppercase(Locale.getDefault()) + dayOfWeek.substring(1)
        }
    }

    fun formatTemperature(temperature: Double): String {
        return "${Math.round(temperature)}°C"
    }
}