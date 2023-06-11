package com.olgagrafov.ginitask.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object NumberCard {
    @Composable
    fun Item(number: Int, color: Color, ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .width(90.dp),
            elevation = 2.dp,
            backgroundColor = color,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        ) {
            Text(
                text = number.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp
                )
            )
        }
    }
}