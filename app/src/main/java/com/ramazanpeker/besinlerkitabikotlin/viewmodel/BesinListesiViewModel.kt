package com.ramazanpeker.besinlerkitabikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramazanpeker.besinlerkitabikotlin.model.Besin
import com.ramazanpeker.besinlerkitabikotlin.servis.BesinAPIServis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BesinListesiViewModel:ViewModel()
{
    val besinler=MutableLiveData<List<Besin>>()
    val besinHataMesaji=MutableLiveData<Boolean>()
    val besinYukleniyor=MutableLiveData<Boolean>()

    private  val besinAPIServis=BesinAPIServis()
    private val disposable=CompositeDisposable()

    fun refreshData() {
        verileriInternettenAl()
    }
    private fun verileriInternettenAl(){
        besinYukleniyor.value=true
        disposable.add(
                besinAPIServis.getData()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object:DisposableSingleObserver<List<Besin>>(){
                            override fun onSuccess(t: List<Besin>) {
                                //başarılı olursak
                                besinler.value=t
                                besinHataMesaji.value=false
                                besinYukleniyor.value=false
                            }

                            override fun onError(e: Throwable) {
                                besinHataMesaji.value=true
                                besinYukleniyor.value=false
                                e.printStackTrace()

                            }

                        })
        )

    }


}