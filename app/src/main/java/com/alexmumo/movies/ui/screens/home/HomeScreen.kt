package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
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
    val nowplaying = viewModel.nowplaying.value.collectAsLazyPagingItems()
    val toprated = viewModel.toprated.value.collectAsLazyPagingItems()
    val upcoming = viewModel.upcoming.value.collectAsLazyPagingItems()
    val scrollState = rememberScrollState()

    LazyColumn {
        item {
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
        }
        item {
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
        }
        item {
            LazyRow(
                content = {
                    items(upcoming) { upcoming ->
                        MovieCard(
                            movieString = "${Constants.IMAGE_URL}/${upcoming?.backdropPath}",
                            modifier = Modifier
                                .height(200.dp)
                                .width(200.dp)
                                .clickable {
                                    navController.navigate("details/${upcoming?.id}")
                                }
                        )
                    }
                }
            )
        }
        item {
            LazyRow(
                content = {
                    items(nowplaying) { now_playing ->
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
