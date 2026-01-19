package com.example.photoapp.network

import com.example.photoapp.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ImageApi by lazy {
     Retrofit.Builder()
         .baseUrl(Constants.BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
         .create(ImageApi::class.java)
    }
}