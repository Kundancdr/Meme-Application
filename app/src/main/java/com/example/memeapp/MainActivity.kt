package com.example.memeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.memeapp.Api.Meme
import com.example.memeapp.Api.RetrofitInstance
import com.example.memeapp.navigation.NavGraph
import com.example.memeapp.ui.theme.MemeAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemeAppTheme {


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {

                        var memeList by remember {
                            mutableStateOf(listOf<Meme>())
                        }
                        val scope = rememberCoroutineScope()
                        LaunchedEffect(key1 = true) {
                            scope.launch(Dispatchers.IO) {
                                val response = try {
                                    RetrofitInstance.api.getAllMemes()
                                } catch (e: IOException) {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "App erroe :${e.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    return@launch
                                } catch (e: HttpException) {
                                    Toast.makeText(
                                        this@MainActivity,
                                        "Http erroe :${e.message}",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    return@launch
                                }

                                if (response.isSuccessful && response.body() != null) {
                                    withContext(Dispatchers.Main) {
                                        memeList = response.body()!!.data.memes
                                    }
                                }

                            }

                        }
                        NavGraph(memeList = memeList)
                    }
                }
            }
        }
    }
}

