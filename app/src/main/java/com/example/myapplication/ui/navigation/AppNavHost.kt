package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.ProfileScreen
import com.example.myapplication.ui.screens.SettingsScreen
import com.example.myapplication.ui.screens.WeatherScreen

sealed class Screen(val route: String) {
    object Weather : Screen("weather")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Weather.route) {
        composable(Screen.Weather.route) {
            WeatherScreen(
                onOpenProfile = { navController.navigate(Screen.Profile.route) },
                onOpenSettings = { navController.navigate(Screen.Settings.route) })
        }
        composable(Screen.Profile.route) {
            ProfileScreen(onBack = { navController.popBackStack() })
        }
        composable(Screen.Settings.route) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
