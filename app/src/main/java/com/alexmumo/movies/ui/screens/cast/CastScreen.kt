package com.alexmumo.movies.ui.screens.cast

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.alexmumo.domain.models.Cast
import com.alexmumo.movies.ui.common.AppBar
import com.alexmumo.movies.ui.components.CastCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CastScreen(
    cast: Cast,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(
            navController = navController,
            title = {
                Text(
                    color = Color.Magenta,
                    text = "Movie Casts"
                )
            },
            showBackArrow = true
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
        ) {
            item {
                CastCard(cast = cast)
            }
        }
    }
}
