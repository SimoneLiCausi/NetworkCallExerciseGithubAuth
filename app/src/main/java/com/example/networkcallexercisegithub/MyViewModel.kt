package com.example.networkcallexercisegithub

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class MyViewModel: ViewModel() {

    val result = MutableLiveData<CatFactData>()

    fun networkCall(){

        viewModelScope.launch(IO){

            var response = RepositoryCat.networkCall()
            if (response?.isSuccessful == true){
                result.postValue(response.body())
            } else {
                Log.e("NETWORK ERROR","Couldn't achieve network call")
            }
        }
    }

}