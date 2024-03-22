package com.matheuskittler.weather_report.service

import kotlin.coroutines.CoroutineContext

interface AppDispatcher {
    var main: CoroutineContext
    var io: CoroutineContext
}