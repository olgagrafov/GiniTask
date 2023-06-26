package com.olgagrafov.ginitask.model

import androidx.compose.ui.graphics.Color
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
                var retrievedNumbers = repository.getNumbers()
                for(pp in retrievedNumbers){
                    if(NumberData.isContains(pp.number, retrievedNumbers)) {
                        pp.color = Color.Red
                    }
                    else {
                        pp.color = Color.Green
                    }
                }
                _numbers.value = retrievedNumbers.sortedBy { numberItem -> numberItem.number }
            } catch (e: Exception) {
                throw Exception("Failed to retrieve numbers")
            }
        }
    }
}