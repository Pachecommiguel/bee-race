package com.example.beerace.ui.router

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beerace.ui.view.HomeView

@Composable
fun ApplicationNavHost() {
    NavHost(navController = rememberNavController(), startDestination = Destination.Home().route) {
        composable(route = Destination.Home().route) {
            HomeView()
        }
    }
}