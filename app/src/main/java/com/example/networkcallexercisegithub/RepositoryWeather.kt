package com.example.networkcallexercisegithub

import com.example.networkcallexercisegithub.data.WeatherData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RepositoryWeather {
    var weatherEndPoint: WeatherEndPoint? = null




    suspend fun getWeather(): Response<WeatherData>? {
        if (weatherEndPoint == null) {
            weatherEndPoint = createRetrofitInstance().create(WeatherEndPoint::class.java)
        }
        return weatherEndPoint?.networkCall()
    }



    fun createRetrofitInstance(): Retrofit {

        val baseUrl = "https://api.openweathermap.org/data/2.5/"
        val loggingInterceptor = HttpLoggingInterceptor()
        val authInterceptor = MyInterceptor()



        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY



        val httpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}