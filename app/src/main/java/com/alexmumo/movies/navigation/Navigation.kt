package com.alexmumo.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = NavigationItem.Popular.route) {

        composable(NavigationItem.TopRated.route) {
        }
        composable(NavigationItem.Upcoming.route) {
        }
        composable(NavigationItem.Favorite.route) {
        }
    }
}
