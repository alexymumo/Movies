package com.alexmumo.movies.ui.screens.main

/*
@ExperimentalFoundationApi
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

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}

 */

