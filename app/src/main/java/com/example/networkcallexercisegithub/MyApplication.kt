package com.example.networkcallexercisegithub

import android.app.Application
import com.example.networkcallexercisegithub.data.network.WeatherProvider

//STEP 1


// La classe application è un livello sopra l'activity e si usa per creare
// Tutte quelle logiche che devono essere lanciate prima dell'acitivity, tipo
// dei login.


// Per prima cosa creiamo una classe Application, la implementiamo nel Manifest
// e poi creiamo il metodo onCreate del fragment.

// Per gestire retrofit, creiamo un provider.

class MyApplication : Application() {

    private val provider = WeatherProvider().provide()
    val viewModelFactory = MainViewModelFactory(provider)   // <-- Stiamo passando il provider, perche .provide() è la nostra funzione che abbiamo creato per il service.
        // Adesso qualsiasi model che andiamo a creare da questa factory, avrà il provider implementato.
    // Finito il provider, adesso ci serve il view model factory.
    override fun onCreate() {
        super.onCreate()
    }


}