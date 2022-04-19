package com.alexmumo.movies.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexmumo.movies.navigation.BottomNav
import com.alexmumo.movies.navigation.Navigation
import com.alexmumo.movies.navigation.NavigationItem
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    val topLevelDestination = listOf(
        NavigationItem.TopRated,
        NavigationItem.Popular,
        NavigationItem.Upcoming,
        NavigationItem.Favorite
    )
    val isTopLevelDestination = navController.currentBackStackEntryAsState().value?.destination?.route in topLevelDestination.map { it.route }
    val backStackEntryState = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            if (isTopLevelDestination) {
                BottomNav(
                    navController = navController,
                    backStackEntryState = backStackEntryState,
                    bottomItems = topLevelDestination
                )
            }
        }
    ) {
        Navigation(navController = navController)
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
