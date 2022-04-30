package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.domain.models.Movie
import com.alexmumo.movies.ui.components.PopularMoviesUI
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.getViewModel

class MovieState(
    var isLoading: Boolean = false,
    val movieList: Flow<PagingData<Movie>>? = null,
    val errorMessage: String = ""
)

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val popular = viewModel.popular.value.collectAsLazyPagingItems()
    LazyColumn {
        items(popular) { movies ->
            PopularMoviesUI(movie = movies)
        }
    }
}
