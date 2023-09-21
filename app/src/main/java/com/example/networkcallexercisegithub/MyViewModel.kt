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
                result.postValue(response.body())
                Log.i("CURRENT WEATHER", "${response.body()}")
            } else {
                Log.e("NETWORK ERROR","Couldn't achieve network call")
            }
        }
    }

}