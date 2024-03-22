package com.matheuskittler.weather_report.utils

import android.content.Context
import com.matheuskittler.weather_report.R

class GetStrings(context: Context) {
    val illegalArgument = context.getString(R.string.illegal_argument_exception)
    val queryTemperature = context.getString(R.string.temperature)
    val queryHumidity = context.getString(R.string.relative_humidity_2m)
    val queryUvIndex = context.getString(R.string.uv_index)
    val queryIsDay = context.getString(R.string.is_day)
}