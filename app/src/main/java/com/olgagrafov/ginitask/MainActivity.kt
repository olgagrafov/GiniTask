package com.olgagrafov.ginitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.olgagrafov.ginitask.composables.ProgressBar
import com.olgagrafov.ginitask.composables.Content
import com.olgagrafov.ginitask.model.NumbersViewModel
import com.olgagrafov.ginitask.ui.theme.GiniTaskTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: NumbersViewModel by viewModels()

        setContent {
            GiniTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreditCardScreen(viewModel)
                }
            }
        }
    }
}
@Composable
fun CreditCardScreen(viewModel: NumbersViewModel) {
    val numbers by viewModel.numbers.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchNumbers()
    }

    if (numbers.isEmpty()) {
        ProgressBar.CustomCircularProgressBar()
    } else {
        Content.ShowNumbersContent(numbers)
    }
}
