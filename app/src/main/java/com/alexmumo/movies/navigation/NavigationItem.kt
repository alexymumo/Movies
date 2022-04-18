package com.alexmumo.movies.navigation

import com.alexmumo.movies.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_launcher_background, "Home")
    object Popular : NavigationItem("popular", R.drawable.ic_launcher_background, "Popular")
    object TopRated : NavigationItem("toprated", R.drawable.ic_launcher_background, "TopRated")
    object Upcoming : NavigationItem("upcoming", R.drawable.ic_launcher_background, "Upcoming")
    object Favorite : NavigationItem("favorite", R.drawable.ic_launcher_background, "Favorite")
}
