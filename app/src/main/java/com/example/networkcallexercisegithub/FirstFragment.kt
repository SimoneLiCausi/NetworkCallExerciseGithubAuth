package com.example.networkcallexercisegithub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
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
            viewModel.networkCall()
        }

        //TODO: CHIAMIAMO IL MutableLiveData PRESENTE NEL ViewModel E SETTIAMO UN OBSERVE.
        // IL CONTENUTO DELLA FUNZIONE VERRA' ESEGUITO OGNI QUALVOLTA IL CONTENUTO DELLA LIVE DATA CAMBIA
        // VA SPECIFICATO viewLifecycleOwner PERCHE' COSI' L'OBSERVE CAPISCE QUANDO IL FRAGMENT NON E'
        // PIU' VISUALIZZATO A SCHERMO E SMETTE DI OSSERVARE.

       viewModel.result.observe(viewLifecycleOwner){
            setCatText(it)
        }

    }

    //TODO: E' ALTAMENTE CONSIGLIATO CREARE DELLE FUNZIONI APPOSITE PER PULIZIA DEL CODICE

    private fun setCatText(it: CatFactData){
        binding.networkCallTextView.text = it.fact
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}