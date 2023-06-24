package com.olgagrafov.ginitask.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olgagrafov.ginitask.service.NumbersRepository
import kotlinx.coroutines.launch

class NumbersViewModel: ViewModel() {
    private val repository = NumbersRepository()
    private val _numbers = MutableLiveData<List<NumberItem>>()
    val numbers: LiveData<List<NumberItem>>  = _numbers

    fun fetchNumbers() {
        viewModelScope.launch {
            try {
                val retrievedNumbers = repository.getNumbers()
                _numbers.value = retrievedNumbers.sortedBy { numberItem -> numberItem.number }
            } catch (e: Exception) {
                throw Exception("Failed to retrieve numbers")
            }
        }
    }
}