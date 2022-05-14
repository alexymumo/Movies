package com.alexmumo.movies.ui.screens.cast

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.alexmumo.movies.ui.common.Constants
import com.alexmumo.movies.ui.components.CastCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CastScreen() {
    Column {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
        ) {
        }
    }
}
