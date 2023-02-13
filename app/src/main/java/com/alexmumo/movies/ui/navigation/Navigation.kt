package com.alexmumo.movies.ui.navigation
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alexmumo.movies.ui.screens.detail.DetailScreen
import com.alexmumo.movies.ui.screens.favorite.FavoriteScreen
import com.alexmumo.movies.ui.screens.home.HomeScreen
import com.alexmumo.movies.ui.screens.search.SearchScreen
import com.alexmumo.movies.ui.screens.settings.SettingScreen
import com.alexmumo.movies.ui.screens.splash.SplashScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {
        composable(route = NavigationItem.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(route = NavigationItem.Favorite.route) {
            FavoriteScreen(navController = navController)
        }
        composable(route = NavigationItem.Settings.route) {
            SettingScreen()
        }
        composable(
            route = NavigationItem.Details.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                }
            )
        ) {
            val movieID = it.arguments?.getInt("movieId")
            if (movieID != null) {
                DetailScreen(
                    navController = navController,
                    movieId = movieID
                )
            }
        }
    }
}
