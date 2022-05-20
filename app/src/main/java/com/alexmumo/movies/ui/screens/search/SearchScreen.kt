package com.alexmumo.movies.ui.screens.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alexmumo.movies.ui.components.CustomSearchBar
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel(),
    navController: NavController,
    navigateUp: () -> Unit
) {
    val search = viewModel.searchString.value
    CustomSearchBar(
        value = search,
        placeholder = "Search Movies",
        navigateUp = navigateUp,
        onValueChange = { name ->
            viewModel.searchMoviesByName(search)
        }
    )
}
