package com.ramazanpeker.besinlerkitabikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramazanpeker.besinlerkitabikotlin.model.Besin

class BesinDetayViewModel :ViewModel()
{
    val besinLiveData=MutableLiveData<Besin>()
    fun roomVerisiniAl()
    {
        val muz=Besin("muz","100","10","1","2","www.test.com")
        besinLiveData.value=muz
    }
}