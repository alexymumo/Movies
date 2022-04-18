package com.alexmumo.movies.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.alexmumo.movies.common.AppBar
import com.alexmumo.movies.navigation.BottomNav
import com.alexmumo.movies.navigation.Navigation

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNav() }
    ) {
        // Navigation(navController)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
}
