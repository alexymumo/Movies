package com.alexmumo.movies.navigation

import com.alexmumo.movies.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Popular : NavigationItem("popular", R.drawable.ic_upcoming, "Popular")
    object TopRated : NavigationItem("toprated", R.drawable.ic_toprated, "TopRated")
    object Upcoming : NavigationItem("upcoming", R.drawable.ic_upcoming, "Upcoming")
    object Favorite : NavigationItem("favorite", R.drawable.ic_favorite, "Favorite")
    object Splash : NavigationItem("splash", R.drawable.ic_favorite, "Splash")
}
