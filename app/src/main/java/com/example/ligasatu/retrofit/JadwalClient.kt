package com.example.ligasatu.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JadwalClient {
    private var BASE_URL:String="https://www.thesportsdb.com/"
    private var retrofit: Retrofit? = null
    val getJadwal: JadwalInterface
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(JadwalInterface::class.java)!!

        }
}