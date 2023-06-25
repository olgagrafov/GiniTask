package com.olgagrafov.ginitask.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.olgagrafov.ginitask.model.NumberData
import com.olgagrafov.ginitask.model.NumberItem

object Content {
    @Composable
    fun ShowNumbersContent(numbers: List<NumberItem>) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(numbers){
                item: NumberItem ->
                if(NumberData.isContains(item.number, numbers)){
                    NumberCard.Item(number = item.number, color =  Color.Red)
                }
                else{
                    NumberCard.Item(number = item.number, color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}