package com.example.networkcallexercisegithub

import retrofit2.Response
import retrofit2.http.GET

interface CatEndPoint {

    @GET("fact")
    suspend fun networkCall() : Response<CatFactData>

}