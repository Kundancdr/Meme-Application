package com.example.memeapp.Api

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("get_memes")
    suspend fun getAllMemes():Response<AllmemesData>

}