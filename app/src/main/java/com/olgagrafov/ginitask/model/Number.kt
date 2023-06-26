package com.olgagrafov.ginitask.model

import androidx.compose.ui.graphics.Color

data class NumberData(val numbers: List<NumberItem>){
    companion object {
        fun isContains(num: Int, numbers: List<NumberItem>): Boolean {
            val tmp = num * (-1)
            return ((num < 0 && numbers.contains(NumberItem(tmp))) ||
                (num > 0 &&  numbers.contains(NumberItem(tmp))) )
        }
    }
}
data class NumberItem(val number: Int, var color: Color = Color.White){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NumberItem
        if (number != other.number) return false
        return true
    }
}
