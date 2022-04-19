package com.alexmumo.movies.screens.popular

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.PagingData
import com.alexmumo.domain.models.Movie
import com.alexmumo.movies.screens.home.HomeViewModel
import kotlinx.coroutines.flow.Flow

@Composable
fun PopularScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    movies: Flow<PagingData<Movie>>
) {

}

@Preview
@Composable
fun PopularScreenPreview() {
}
