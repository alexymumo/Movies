package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.movies.ui.common.Constants
import com.alexmumo.movies.ui.components.MovieCard
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val popular = viewModel.popular.value.collectAsLazyPagingItems()
    val now_playing = viewModel.nowplaying.value.collectAsLazyPagingItems()
    val toprated = viewModel.toprated.value.collectAsLazyPagingItems()
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Top Rated")
            LazyRow(
                content = {
                    items(toprated) { toprated ->
                        MovieCard(
                            movieString = "${Constants.IMAGE_URL}/${toprated?.backdropPath}",
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                                .clickable {
                                    navController.navigate("details/${toprated?.id}")
                                }
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Popular Movies")
            LazyRow(
                content = {
                    items(popular) { popular ->
                        MovieCard(
                            movieString = "${Constants.IMAGE_URL}/${popular?.backdropPath}",
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                                .clickable {
                                    navController.navigate("details/${popular?.id}")
                                }
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Now Playing")
            LazyRow(
                content = {
                    items(now_playing) { now_playing ->
                        MovieCard(
                            movieString = "${Constants.IMAGE_URL}/${now_playing?.backdropPath}",
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                                .clickable {
                                    navController.navigate("details/${now_playing?.id}")
                                }
                        )
                    }
                }
            )
        }
    }
}
