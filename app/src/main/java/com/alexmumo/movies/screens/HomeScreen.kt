package com.alexmumo.movies.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.movies.components.MovieGrid
import com.alexmumo.presentation.viewmodel.MovieViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: MovieViewModel = getViewModel()) {
    val state = viewModel.movieListState.value
    val lazyGridState = rememberLazyGridState()

    val movies = state.movieList?.collectAsLazyPagingItems()

    movies?.let { items ->
        MovieGrid(items = items, lazyGridState)
    }
}
