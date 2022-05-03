package com.alexmumo.movies.ui.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = getViewModel()
) {
    Text(text = "Favorite Screen", Modifier.background(color = Color.Magenta))
}

@Preview
@Composable
fun FavoriteScreenPreview() {
}
