package com.example.lab_06

// Sealed class para definir rutas de manera segura (Type-safe)
sealed class Screen(val route: String) {
    object Main : Screen("main_screen")
    object Profile : Screen("profile_screen")
    object Build : Screen("build_screen")
    object Menu : Screen("menu_screen")
    object Favorite : Screen("favorite_screen")
    object Delete : Screen("delete_screen")
}