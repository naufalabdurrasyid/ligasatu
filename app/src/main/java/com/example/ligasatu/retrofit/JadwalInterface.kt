package com.example.ligasatu.retrofit

import com.example.ligasatu.model.JadwalModel
import com.example.ligasatu.model.SemuaPertandingan
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Streaming

interface JadwalInterface {
    @Streaming
    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    fun getPertandingan(): Call<List<SemuaPertandingan>>
}