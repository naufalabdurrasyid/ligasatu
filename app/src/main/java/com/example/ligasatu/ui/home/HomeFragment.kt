package com.example.ligasatu.ui.home

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ligasatu.MainActivity
import com.example.ligasatu.R
import com.example.ligasatu.adapter.JadwalAdapter
import com.example.ligasatu.model.JadwalModel
import com.example.ligasatu.model.SemuaPertandingan
import com.example.ligasatu.retrofit.JadwalClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    var pertandinganList = ArrayList<SemuaPertandingan>()
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.recycler_view)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
            recyclerView = root.findViewById(R.id.recycler_view)
            //setting up the adapter
            recyclerView.adapter= JadwalAdapter(pertandinganList, this.requireContext())
            recyclerView.layoutManager= LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
            getDataPertandingan()
        })
        return root
    }
    private fun getDataPertandingan() {
        val call: Call<List<SemuaPertandingan>> = JadwalClient.getJadwal.getPertandingan()
        call.enqueue(object : Callback<List<SemuaPertandingan>> {

            override fun onResponse(call: Call<List<SemuaPertandingan>>?, response: Response<List<SemuaPertandingan>>?) {
                pertandinganList.addAll(response!!.body()!!)
                recyclerView.adapter!!.notifyDataSetChanged()

            }
            override fun onFailure(call: Call<List<SemuaPertandingan>>?, t: Throwable?) {
                return pertandinganList.trimToSize()
            }

        })
    }
}