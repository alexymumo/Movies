package com.alexmumo.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.movies.screens.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {

        composable(route = NavigationItem.TopRated.route) {
            HomeScreen(navController)
        }
        composable(route = NavigationItem.Upcoming.route) {
        }
        composable(route = NavigationItem.Favorite.route) {
        }
        composable(route = NavigationItem.Popular.route) {
        }
    }
}
