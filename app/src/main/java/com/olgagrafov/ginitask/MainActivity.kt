package com.olgagrafov.ginitask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.olgagrafov.ginitask.composables.ProgressBar
import com.olgagrafov.ginitask.composables.Content
import com.olgagrafov.ginitask.model.Numbers
import com.olgagrafov.ginitask.service.MyRetrofitApiInterface
import com.olgagrafov.ginitask.service.RetrofitHelper
import com.olgagrafov.ginitask.ui.theme.GiniTaskTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private var showProgressBar: MutableState<Boolean> = mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromServer()
        setContent {
            GiniTaskTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (showProgressBar.value)
                        ProgressBar.CustomCircularProgressBar()
                    else
                        Content.ShowNumbersContent()
                }
            }
        }
    }

    private fun getDataFromServer() {
        GlobalScope.launch {
            val apiService =
                RetrofitHelper.getApiInstance().create(MyRetrofitApiInterface::class.java)
            val call = apiService.getNumbers()

            val response = call.execute()

            if (response.isSuccessful) {
                val numberData = response.body()
                numberData?.numbers?.forEach { numberItem ->
                    Numbers.NumbersList.add(numberItem.number)
                }
                Numbers.NumbersList = Numbers.NumbersList.sorted().toMutableList()
                showProgressBar.value = false
            } else {
                println("API request failed with status code: ${response.code()}")
            }
        }
    }
}
