package com.alexmumo.movies.screens

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.presentation.viewmodel.MovieViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: MovieViewModel = getViewModel()) {
    val state = viewModel.movieListState.value
    val lazyListState = rememberLazyListState()

    val movies = state.movieList?.collectAsLazyPagingItems()

    movies?.let {

    }
}
