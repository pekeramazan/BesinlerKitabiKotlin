package com.ramazanpeker.besinlerkitabikotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ramazanpeker.besinlerkitabikotlin.R
import com.ramazanpeker.besinlerkitabikotlin.viewmodel.BesinDetayViewModel
import kotlinx.android.synthetic.main.fragment_besin_detay.*


class BesinDetayFragment : Fragment() {
    private lateinit var  viewModel:BesinDetayViewModel
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

        viewModel=ViewModelProviders.of(this).get(BesinDetayViewModel::class.java)
        viewModel.roomVerisiniAl()



        arguments?.let {
            besinId= BesinDetayFragmentArgs.fromBundle(it).besinId

        }
        observeLiveData();

    }
    fun observeLiveData()
    {
        viewModel.besinLiveData.observe(viewLifecycleOwner, Observer{ besin->
            besin?.let{
                besinIsmi.text=it.besinIsmi
                besinKalori.text=it.besinKalori
                besinKarbonhidrat.text=it.besinKArbonhidrat
                besinProtein.text=it.besinProtein
                besinYag.text=it.besinYag
            }
        })

    }


    }
