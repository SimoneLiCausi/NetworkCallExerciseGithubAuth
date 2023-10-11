package com.example.networkcallexercisegithub.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.networkcallexercisegithub.data.WeatherData
import com.example.networkcallexercisegithub.data.network.WeatherService

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

//STEP 4

// Aggiungiamo il service nel costruttore del nostro view model
class WeatherViewModel(private val service: WeatherService) : ViewModel() {

    val result = MutableLiveData<WeatherData>()
    val cityNames = mutableListOf<String>()


    fun getWeather() {

        viewModelScope.launch(IO) {
// Abbiamo modificato la response adesso.
            var response = service.getWeather("q")
            // Non serve più il true, perchè prima il service era nella repo come null, adesso invece
            // non lo è più.
            if (response.isSuccessful) {
                result.postValue(response.body())
                Log.i("CURRENT WEATHER", "${response.body()}")
            } else {
                Log.e("NETWORK ERROR", "Couldn't achieve network call")
            }
        }
    }

    fun getCityNames() {
        viewModelScope.launch(IO) {


        }
    }

}