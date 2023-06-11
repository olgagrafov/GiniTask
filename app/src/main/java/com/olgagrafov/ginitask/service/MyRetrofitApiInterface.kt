package com.olgagrafov.ginitask.service

import com.olgagrafov.ginitask.model.NumberData
import retrofit2.Call
import retrofit2.http.GET

interface MyRetrofitApiInterface {
    @GET("8wJzytQX")
    fun getNumbers(): Call<NumberData>
}