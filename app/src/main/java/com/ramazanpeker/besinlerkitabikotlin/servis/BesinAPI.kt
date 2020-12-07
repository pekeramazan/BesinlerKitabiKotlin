package com.ramazanpeker.besinlerkitabikotlin.servis

import com.ramazanpeker.besinlerkitabikotlin.model.Besin
import io.reactivex.Single
import retrofit2.http.GET

interface BesinAPI {


    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json


    @GET ("/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")
    fun getBesin(): Single<List<Besin>>//RXJava kullanılan kısım      //single veriyi 1 defa çekip sonra durur,veri akışı yoktur





}