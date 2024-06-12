package com.example.memeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.memeapp.Api.Meme
import com.example.memeapp.screens.AllMemeScreen
import com.example.memeapp.screens.DetailScreen

@Composable
fun NavGraph(memeList: List<Meme>) {
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = Routes.AllMemeScreen) {

        composable<Routes.AllMemeScreen> {
            AllMemeScreen(modifier = Modifier,navController,memeList)
        }
        composable<Routes.DetailScreen> {backStackEntry ->
            val data :Routes.DetailScreen = backStackEntry.toRoute()
            DetailScreen(modifier = Modifier,data,navController)

        }
    }
}