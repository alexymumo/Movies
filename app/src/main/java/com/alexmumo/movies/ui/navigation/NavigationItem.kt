package com.alexmumo.movies.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexmumo.movies.R

sealed class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int?,
    @StringRes val title: Int?
) {
    object Home : NavigationItem("toprated", R.drawable.ic_home, R.string.home)
    object Favorite : NavigationItem("favorite", R.drawable.ic_favorite, R.string.favorite)
    object Details : NavigationItem("details/{movieId}", null, R.string.details)
    object Splash : NavigationItem("splash", null, R.string.favorite)
    object Search : NavigationItem("search", R.drawable.ic_search, R.string.search)

    object Settings : NavigationItem("settings", R.drawable, R.string.search)
}
