package com.ramazanpeker.besinlerkitabikotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_besin_detay.*


class BesinDetayFragment : Fragment() {
private var besinId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            besinId=BesinDetayFragmentArgs.fromBundle(it).besinId

        }
        besin_detay_button0.setOnClickListener{
            val action=BesinDetayFragmentDirections.actionBesinDetayFragmentToBesinListesiFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }


    }
