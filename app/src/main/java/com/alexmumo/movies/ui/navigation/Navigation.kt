package com.alexmumo.movies.ui.navigation

/*
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {
        composable(route = NavigationItem.Splash.route) {
            SplashScreen(navController = navController)
        }
      /*  composable(route = NavigationItem.TopRated.route) {
            HomeScreen(navController = navController)
        }

       */
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

 */
