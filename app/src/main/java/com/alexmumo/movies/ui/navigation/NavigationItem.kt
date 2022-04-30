package com.alexmumo.movies.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexmumo.movies.R

sealed class NavigationItem(
    var route: String,
    @DrawableRes val icon: Int?,
    @StringRes val title: Int
) {
    object Popular : NavigationItem("popular", R.drawable.ic_toprated, R.string.popular)
    object TopRated : NavigationItem("toprated", R.drawable.ic_home, R.string.home)
    object Upcoming : NavigationItem("upcoming", R.drawable.ic_upcoming, R.string.upcoming)
    object Favorite : NavigationItem("favorite", R.drawable.ic_favorite, R.string.favorite)
    object Splash : NavigationItem("splash", null, R.string.favorite)
}
