package com.olgagrafov.ginitask.model
 data class NumberData(val numbers: List<NumberItem>){
    companion object {
        fun isContains(num: Int, numbers: List<NumberItem>): Boolean {
            return ((num < 0 && numbers.contains(NumberItem(num * (-1)))) ||
                (num > 0 &&  numbers.contains(NumberItem(num * (-1)))) )
        }
    }
}
data class NumberItem(val number: Int)
