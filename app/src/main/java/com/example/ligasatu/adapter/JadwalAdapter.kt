package com.example.ligasatu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ligasatu.R
import com.example.ligasatu.model.SemuaPertandingan

class JadwalAdapter(private var pertandinganList: ArrayList<SemuaPertandingan> , private val context: Context) : RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pertandingan, parent, false))

    }

    override fun getItemCount(): Int {
        return pertandinganList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pertandinganModel=pertandinganList.get(position)
//
        holder.pertandingannya.text=pertandinganModel.strEvent

    }
    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var pertandingannya: TextView = itemLayoutView.findViewById(R.id.pertandingan)




    }

}