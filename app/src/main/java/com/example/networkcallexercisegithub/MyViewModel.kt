package com.example.networkcallexercisegithub

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.networkcallexercisegithub.data.WeatherData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MyViewModel: ViewModel() {

    val result = MutableLiveData<WeatherData>()


    fun getWeather(){

        viewModelScope.launch(IO){

            var response = RepositoryWeather.getWeather()
            if (response?.isSuccessful == true){

                val currentWeather = response.body()?.weather
                val currentClouds = response.body()?.clouds
                val weatherData = WeatherData(weather = currentWeather, clouds = currentClouds, base = null, visibility = null,
                    rain = null, timezone = null, wind = null, sys = null, name = null, cod = null, coord = null, id = null, dt = null, main = null)

                result.postValue(weatherData)
                Log.i("CURRENT WEATHER", "$currentWeather")
                Log.i("CURRENT CLOUDS", "$currentClouds")
            } else {
                Log.e("NETWORK ERROR","Couldn't achieve network call")
            }
        }
    }

}