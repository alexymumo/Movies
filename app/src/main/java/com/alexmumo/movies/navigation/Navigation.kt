package com.alexmumo.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.movies.screens.home.HomeScreen
import com.alexmumo.movies.screens.splash.SplashScreen
import com.alexmumo.movies.screens.favorite.FavoriteScreen
import com.alexmumo.movies.screens.popular.PopularScreen
import com.alexmumo.movies.screens.upcoming.UpcomingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {
        composable(route = NavigationItem.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationItem.TopRated.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Upcoming.route) {
            UpcomingScreen(navController = navController)
        }
        composable(route = NavigationItem.Favorite.route) {
            FavoriteScreen(navController = navController)
        }
        composable(route = NavigationItem.Popular.route) {
            PopularScreen(navController = navController)
        }
    }
}
