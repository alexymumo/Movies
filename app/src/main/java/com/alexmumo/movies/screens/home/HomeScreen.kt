package com.alexmumo.movies.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val popularMovies = viewModel.popularMovies.observeAsState().value
}

@Composable
fun PopularMovieCard(
    navController: NavController,
    viewModel: HomeViewModel,
    movies: Flow<PagingData<Movie>>
) {

}

@Preview
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
}
