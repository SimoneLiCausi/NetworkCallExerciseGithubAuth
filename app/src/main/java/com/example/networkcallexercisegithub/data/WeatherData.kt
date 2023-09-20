package com.example.networkcallexercisegithub.data


import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("base")
    val base: String?,
    @SerializedName("clouds")
    val clouds: AllDataWeather.Clouds?,
    @SerializedName("cod")
    val cod: Int?,
    @SerializedName("coord")
    val coord: AllDataWeather.Coord?,
    @SerializedName("dt")
    val dt: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("main")
    val main: AllDataWeather.Main?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rain")
    val rain: AllDataWeather.Rain?,
    @SerializedName("sys")
    val sys: AllDataWeather.Sys?,
    @SerializedName("timezone")
    val timezone: Int?,
    @SerializedName("visibility")
    val visibility: Int?,
    @SerializedName("weather")
    val weather: List<AllDataWeather.Weather?>?,
    @SerializedName("wind")
    val wind: AllDataWeather.Wind?
)