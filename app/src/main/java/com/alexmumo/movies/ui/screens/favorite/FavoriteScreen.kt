package com.alexmumo.movies.ui.screens.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.movies.ui.composables.FavoriteItem
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(5.dp)
    ) {
        val liked = viewModel.likedMovies.observeAsState(initial = emptyList())
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = liked.value) { liked ->
                FavoriteItem(movieEntity = liked)
            }
        }
    }
}
