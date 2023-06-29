package com.olgagrafov.ginitask.model

import androidx.compose.ui.graphics.Color

data class NumberData(val numbers: List<NumberItem>){
}
data class NumberItem(val number: Int) {
    private var color: Color? = null
    fun getColor(): Color {
        return if(this.color == null) Color.Green else this.color!!
    }
    fun setColor(color:Color){
        this.color = color
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as NumberItem
        if (number != other.number) return false
        return true
    }
    override fun hashCode(): Int {
        return number
    }
}
