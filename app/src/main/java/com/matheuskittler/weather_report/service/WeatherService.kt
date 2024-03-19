package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit

class WeatherService(private val retrofit: Retrofit) : IWeatherService {

    private val weatherAPI: IWeatherAPI by lazy {
        retrofit.create(IWeatherAPI::class.java)
    }

    override suspend fun getWeatherData(
        latitude: String,
        longitude: String,
        forecastDays: Int,
        temperature: String,
        hourly: String
    ): Flow<Location> {
        return flow {
            val response = weatherAPI.getWeatherReport(latitude, longitude, forecastDays, temperature, hourly)
            if (response.isSuccessful) {
                val location = response.body() ?: throw IllegalStateException("Resposta vazia")
                emit(location) // Emitir o resultado do serviço como um fluxo
            } else {
                throw IllegalStateException("Erro na requisição: ${response.code()} - ${response.message()}")
            }
        }
    }
}