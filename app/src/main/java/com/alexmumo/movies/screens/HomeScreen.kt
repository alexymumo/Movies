package com.alexmumo.movies.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexmumo.movies.common.AppBar
import com.alexmumo.movies.navigation.BottomNav

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNav() }
    ) {
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
