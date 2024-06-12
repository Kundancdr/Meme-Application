package com.example.memeapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object AllMemeScreen

    @Serializable
    data class DetailScreen(
        val url: String,
        val title: String
    )
}