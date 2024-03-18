package com.matheuskittler.weather_report.service

import com.matheuskittler.weather_report.model.Location
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




//fun getInfo() {
//    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.open-meteo.com")
//        .addConverterFactory(GsonConverterFactory.create()).client(
//            OkHttpClient.Builder()
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .build()
//        ).build()
//
//
//
//    retrofit.create(IWeatherAPI::class.java)
//        .getWeatherReport("-29.9422", "-50.9928", 7, "temperature_2m", "temperature_2m")
//        .enqueue(object : Callback<Location> {
//            override fun onFailure(call: Call<Location>, t: Throwable) {
//                Log.d("ERROR", t.toString())
//            }
//
//            override fun onResponse(call: Call<Location>, response: Response<Location>) {
//                if (response != null && response.body() != null) {
//                    response.body()
//                } else {
//                    Log.d("ERROR", response.toString())
//                }
//            }
//        })
//}

    suspend fun getWeatherData(
        latitude: String,
        longitude: String,
        forecastDays: Int,
        temperature: String,
        hourly: String
    ): Location {
        try {
            // Configurando o cliente HTTP com um interceptor de logging
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Criando o objeto Retrofit com a URL base e o cliente HTTP configurado
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            // Criando uma instância da interface da API de previsão do tempo
            val weatherAPI = retrofit.create(IWeatherAPI::class.java)

            // Chamando o método da API para obter os dados meteorológicos
            return weatherAPI.getWeatherReport(
                latitude,
                longitude,
                forecastDays,
                temperature,
                hourly
            )
        } catch (e: Exception) {
            // Em caso de erro, lançar uma exceção
            throw IllegalStateException("Erro ao obter dados meteorológicos: ${e.message}", e)
        }
    }

//    suspend fun getWeatherData(latitude: String, longitude: String, forecastDays: Int, temperature: String, hourly: String): Location {
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://api.open-meteo.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val apiService = retrofit.create(IWeatherAPI::class.java)
//        return apiService.getWeatherReport(latitude, longitude, forecastDays, temperature, hourly)