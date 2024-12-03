package com.example.beerace.ui.router

sealed class Destination {
    data class Home(val route: String = "Home"): Destination()
}