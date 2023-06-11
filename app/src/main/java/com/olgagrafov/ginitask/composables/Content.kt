package com.olgagrafov.ginitask.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.olgagrafov.ginitask.model.Numbers
import com.olgagrafov.ginitask.ui.theme.GiniTaskTheme

object Content {
    @Composable
    fun ShowNumbersContent() {
        val myAPIList = remember { Numbers.NumbersList }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(myAPIList) { num ->
                if(Numbers.NumbersList.contains(Math.abs(num))) {
                    NumberCard.Item(number = num, color =  Color.Red)
                }
                else{
                    NumberCard.Item(number = num, color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}