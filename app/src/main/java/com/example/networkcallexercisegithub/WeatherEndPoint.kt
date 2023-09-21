package com.example.networkcallexercisegithub

import com.example.networkcallexercisegithub.data.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherEndPoint {

    @GET("current.json")
    suspend fun networkCall(@Query ("q") query: String) : Response<WeatherData>

}