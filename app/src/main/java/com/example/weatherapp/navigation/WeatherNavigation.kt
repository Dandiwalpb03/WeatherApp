package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.screens.main.MainScreen
import com.example.weatherapp.screens.splash.WeatherSplashScreen

/**
 * */

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    // NavHost will be used to navigate between screens( this will be a host for all screens )
    // will know which screen to show based on current route.
    NavHost(navController = navController, // will be used to manage navigation.
        startDestination = WeatherScreens.SplashScreen.name ){
        // This composable will be used to show the splash screen (after this all is navgraph)
        composable(WeatherScreens.SplashScreen.name){
            WeatherSplashScreen(navController = navController)
        }

        composable(WeatherScreens.MainScreen.name){
            MainScreen(navController = navController)
        }


    }
}