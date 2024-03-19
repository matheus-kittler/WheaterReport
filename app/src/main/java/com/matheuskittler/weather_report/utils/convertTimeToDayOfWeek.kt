package com.matheuskittler.weather_report.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun convertTimeToDayOfWeek(dateList: List<String>): List<String> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
    val locale = Locale.getDefault()
    val dayOfWeekList = mutableListOf<String>()
    for (date in dateList) {
        val dateTime = LocalDateTime.parse(date, formatter)
        val dayOfWeek = dateTime.dayOfWeek.getDisplayName(TextStyle.FULL, locale)
        dayOfWeekList.add(dayOfWeek)
    }
    return dayOfWeekList
}