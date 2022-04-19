package com.alexmumo.movies.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = getViewModel()) {
}

@Preview
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
}
