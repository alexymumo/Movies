package com.alexmumo.movies.screens.popular

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun PopularScreen(navController: NavController) {
    Text(text = "Popular Screen", Modifier.background(color = Color.DarkGray))
}

@Preview
@Composable
fun PopularScreenPreview() {
}
