package com.alexmumo.movies.ui.screens.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alexmumo.movies.ui.common.AppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            title = {
                Text(
                    text = "Liked Movies",
                    color = Color.Green
                )
            }
        )

    }
}
