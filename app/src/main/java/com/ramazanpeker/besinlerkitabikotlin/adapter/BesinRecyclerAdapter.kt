package com.ramazanpeker.besinlerkitabikotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ramazanpeker.besinlerkitabikotlin.R
import com.ramazanpeker.besinlerkitabikotlin.model.Besin
import com.ramazanpeker.besinlerkitabikotlin.util.gorselIndir
import com.ramazanpeker.besinlerkitabikotlin.util.placeHolderYap
import com.ramazanpeker.besinlerkitabikotlin.view.BesinListesiFragmentDirections
import kotlinx.android.synthetic.main.besin_recycler_row.view.*

class BesinRecyclerAdapter(val besinListesi:ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>()
{
    class BesinViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.besin_recycler_row,parent,false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.isim.text=besinListesi.get(position).besinIsmi
        holder.itemView.kalori.text=besinListesi.get(position).besinKalori
        //görsel kısmı eklenecek
        holder.itemView.imageView.gorselIndir(besinListesi.get(position).besinGorsel, placeHolderYap(holder.itemView.context))

        holder.itemView.setOnClickListener{
            val action=BesinListesiFragmentDirections.actionBesinListesiFragmentToBesinDetayFragment(0)
            Navigation.findNavController(it).navigate(action)

        }
    }



    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi:List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()

    }

}