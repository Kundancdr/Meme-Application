package com.example.memeapp.Api

import com.example.memeapp.Utils.util
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val clint = OkHttpClient.Builder().build()

    val api = Retrofit.Builder().client(clint)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(util.BASE_URL)
        .build()
        .create(ApiInterface::class.java)
}