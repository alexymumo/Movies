package com.alexmumo.movies.screens.upcoming

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun UpcomingScreen(navController: NavController) {
    Text(
        text = "Hello Upcoming Screen",
        fontWeight = FontWeight.Bold
    )
}
