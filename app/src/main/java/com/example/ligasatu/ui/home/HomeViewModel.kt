package com.example.ligasatu.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ligasatu.model.JadwalModel
import com.example.ligasatu.retrofit.JadwalClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections.addAll

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text



}