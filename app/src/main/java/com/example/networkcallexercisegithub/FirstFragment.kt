package com.example.networkcallexercisegithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.networkcallexercisegithub.data.WeatherData
import com.example.networkcallexercisegithub.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel : MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.getWeather()
        }

        //TODO: CHIAMIAMO IL MutableLiveData PRESENTE NEL ViewModel E SETTIAMO UN OBSERVE.
        // IL CONTENUTO DELLA FUNZIONE VERRA' ESEGUITO OGNI QUALVOLTA IL CONTENUTO DELLA LIVE DATA CAMBIA
        // VA SPECIFICATO viewLifecycleOwner PERCHE' COSI' L'OBSERVE CAPISCE QUANDO IL FRAGMENT NON E'
        // PIU' VISUALIZZATO A SCHERMO E SMETTE DI OSSERVARE.

       viewModel.result.observe(viewLifecycleOwner){
            setWeatherText(it)
        }

    }

    //TODO: E' ALTAMENTE CONSIGLIATO CREARE DELLE FUNZIONI APPOSITE PER PULIZIA DEL CODICE

    private fun setWeatherText(it: WeatherData){
        binding.networkCallTextView.text = it.clouds.toString()
        binding.networkCallTextView2.text = it.weather.toString()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}