package com.olgagrafov.ginitask.service

import com.olgagrafov.ginitask.model.NumberData
import retrofit2.Response
import retrofit2.http.GET

interface NumbersService {
    @GET("8wJzytQX")
    suspend fun getNumbers(): Response<NumberData>
}