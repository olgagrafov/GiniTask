package com.olgagrafov.ginitask.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseUrl = "https://pastebin.com/raw/"

    fun getApiInstance(): Retrofit {
        return Retrofit.Builder()
       .baseUrl(baseUrl)
       .addConverterFactory(GsonConverterFactory.create())
       .build()!!
    }
}