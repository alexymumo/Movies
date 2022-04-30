package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.movies.ui.common.Constants.IMAGE_URL
import com.alexmumo.movies.ui.components.PopularMoviesUI
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val popular = viewModel.popular.value.collectAsLazyPagingItems()
    LazyColumn {
        items(popular) { movies ->
            PopularMoviesUI(movie = movies)
            // PopularMoviesCard(movieString = "IMAGE_URL/${movies?.backdropPath}")
        }
    }
}
