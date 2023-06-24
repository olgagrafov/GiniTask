package com.olgagrafov.ginitask.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://pastebin.com/raw/" //https://pastebin.com/raw/8wJzytQX

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val numbersService: NumbersService by lazy {
        retrofit.create(NumbersService::class.java)
    }
}