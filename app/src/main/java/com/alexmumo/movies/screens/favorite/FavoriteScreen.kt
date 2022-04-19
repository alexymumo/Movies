package com.alexmumo.movies.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun FavoriteScreen(navController: NavController) {
    Text(text = "Favorite Screen", Modifier.background(color = Color.Magenta))
}

@Preview
@Composable
fun FavoriteScreenPreview() {
}
