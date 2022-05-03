package com.alexmumo.movies.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: DetailViewModel = getViewModel(),
    movieId: Int
) {

}
