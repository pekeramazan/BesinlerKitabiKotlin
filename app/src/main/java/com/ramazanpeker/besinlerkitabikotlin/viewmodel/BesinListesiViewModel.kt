package com.ramazanpeker.besinlerkitabikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramazanpeker.besinlerkitabikotlin.model.Besin

class BesinListesiViewModel:ViewModel()
{
    val besinler=MutableLiveData<List<Besin>>()
    val besinHataMesaji=MutableLiveData<Boolean>()
    val besinYukleniyor=MutableLiveData<Boolean>()
    fun refreshData()
    {
        val muz=Besin("muz","100","10","1","2","www.test.com")
        val cilek=Besin("çilek","200","8","7","2","www.test.com")
        val elma=Besin("elma","300","10","6","4","www.test.com")
        val armut=Besin("armut","100","20","1","5","www.test.com")

        val besinListesi=arrayListOf<Besin>(muz,cilek,elma,armut)

        besinler.value=besinListesi
        besinHataMesaji.value=false
        besinYukleniyor.value=false
    }

}