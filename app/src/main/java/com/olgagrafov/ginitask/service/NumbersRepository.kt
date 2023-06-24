package com.olgagrafov.ginitask.service

import com.olgagrafov.ginitask.model.NumberItem

class NumbersRepository {

    private val numberService = RetrofitHelper.numbersService

    suspend fun getNumbers(): List<NumberItem> {
        val response = numberService.getNumbers()
        if (response.isSuccessful) {
            return response.body()?.numbers ?: emptyList()
        } else {
            throw Exception("Failed to retrieve numbers")
        }
    }
}