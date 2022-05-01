package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
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
    val listState: LazyListState = rememberLazyListState()
    val popular = viewModel.popular.value.collectAsLazyPagingItems()
    val now_playing = viewModel.nowplaying.value.collectAsLazyPagingItems()
    LazyRow(
        content = {
            items(popular) { movie ->
                MovieCard(
                    movieString = "${Constants.IMAGE_URL}/${movie?.backdropPath}",
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
            }
            items(now_playing) { movie ->
                MovieCard(
                    movieString = "${Constants.IMAGE_URL}/${movie?.backdropPath}",
                    modifier = Modifier
                        .height(200.dp)
                        .width(200.dp)
                )
            }
        }
    )
}

/*{
        items(popular) { movie ->
            MovieCard(
                movieString = "${Constants.IMAGE_URL}/${movie?.backdropPath}",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )
        }

    }

     */
