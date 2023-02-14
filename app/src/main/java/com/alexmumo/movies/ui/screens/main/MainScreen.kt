package com.alexmumo.movies.ui.screens.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexmumo.movies.ui.navigation.BottomNav
import com.alexmumo.movies.ui.navigation.Navigation
import com.alexmumo.movies.ui.navigation.NavigationItem
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    val topLevelDestination = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
        NavigationItem.Favorite,
        NavigationItem.Settings
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

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
