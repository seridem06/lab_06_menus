package com.example.lab_06

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        // Pantalla Principal
        composable(Screen.Main.route) {
            MainScreen(navController)
        }

        // Pantallas Secundarias
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Build.route) {
            BuildScreen(navController)
        }
        composable(Screen.Menu.route) {
            MenuScreen(navController)
        }
        composable(Screen.Favorite.route) {
            FavoriteScreen(navController)
        }
        composable(Screen.Delete.route) {
            DeleteScreen(navController)
        }
    }
}
