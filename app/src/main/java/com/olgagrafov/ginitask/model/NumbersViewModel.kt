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
                var retrievedNumbers = repository.getNumbers().sortedBy { numberItem -> numberItem.number }
                for(num in retrievedNumbers){
                    if (num.number >= 0) break
                    val tmp = num.number * (-1)
                    if(retrievedNumbers.contains(NumberItem(tmp))) {
                        num.setColor(Color.Red)
                        val index = retrievedNumbers.indexOf(NumberItem(tmp))
                        retrievedNumbers[index].setColor(Color.Red)
                    }
                }
                _numbers.value = retrievedNumbers
            } catch (e: Exception) {
                throw Exception("Failed to retrieve numbers")
            }
        }
    }
}