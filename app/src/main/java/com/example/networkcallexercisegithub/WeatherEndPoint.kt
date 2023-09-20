package com.example.networkcallexercisegithub

import com.example.networkcallexercisegithub.data.WeatherData
import retrofit2.Response
import retrofit2.http.GET

interface WeatherEndPoint {

    @GET("AllDataWeather.json")
    suspend fun networkCall() : Response<WeatherData>

}