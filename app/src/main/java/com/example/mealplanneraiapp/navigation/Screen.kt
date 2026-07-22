package com.example.mealplanneraiapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Recipes : Screen("recipes", "Recipes", Icons.Default.RestaurantMenu)
    object Grocery : Screen("grocery", "Grocery", Icons.Default.ShoppingCart)
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Recipes,
    Screen.Grocery,
    Screen.Profile
)
