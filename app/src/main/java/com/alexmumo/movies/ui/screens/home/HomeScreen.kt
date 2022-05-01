package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.movies.ui.components.PopularMovieItem
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val popular = viewModel.popular.value.collectAsLazyPagingItems()
    LazyColumn {
        items(popular) { movie ->
            PopularMovieItem(movie = movie!!)
        }
    }
}
