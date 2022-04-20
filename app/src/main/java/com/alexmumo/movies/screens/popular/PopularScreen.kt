package com.alexmumo.movies.screens.popular

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.domain.models.Movie
import com.alexmumo.movies.components.PopularMovies
import com.alexmumo.movies.screens.home.HomeViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun PopularScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    movies: Flow<PagingData<Movie>>
) {
    val movieList = movies.collectAsLazyPagingItems()
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(items = movieList) {
            PopularMovies(
                modifier = Modifier.fillMaxWidth(),
                movie = it!!,
                viewModel = viewModel
            )
        }
    }
}

@Preview
@Composable
fun PopularScreenPreview() {
}
