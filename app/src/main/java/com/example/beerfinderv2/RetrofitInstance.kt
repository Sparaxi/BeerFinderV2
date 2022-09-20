package com.example.beerfinderv2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api: PunkApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.punkapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PunkApi::class.java)
    }
}