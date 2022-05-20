package com.alexmumo.movies.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.movies.ui.components.AppBar
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

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(
            navController = navController,
            title = {
                Column {
                    Text(
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Serif,
                        text = "Movie App",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false
        )

        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Popular",
                    color = Color.White,
                    fontSize = 18.sp
                )
                LazyRow(
                    content = {
                        items(popular) { popular ->
                            MovieCard(
                                movieString = "${Constants.IMAGE_URL}/${popular?.backdropPath}",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(130.dp)
                                    .clickable {
                                        navController.navigate("details/${popular?.id}")
                                    }
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Toprated",
                    color = Color.White,
                    fontSize = 18.sp
                )
                LazyRow(
                    content = {
                        items(toprated) { toprated ->
                            MovieCard(
                                movieString = "${Constants.IMAGE_URL}/${toprated?.backdropPath}",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(130.dp)
                                    .clickable {
                                        navController.navigate("details/${toprated?.id}")
                                    }
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Upcoming",
                    color = Color.White,
                    fontSize = 18.sp
                )
                LazyRow(
                    content = {
                        items(upcoming) { upcoming ->
                            MovieCard(
                                movieString = "${Constants.IMAGE_URL}/${upcoming?.backdropPath}",
                                modifier = Modifier
                                    .height(200.dp)
                                    .width(130.dp)
                                    .clickable {
                                        navController.navigate("details/${upcoming?.id}")
                                    }
                            )
                        }
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Now Playing",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    LazyRow(
                        content = {
                            items(nowplaying) { now_playing ->
                                MovieCard(
                                    movieString = "${Constants.IMAGE_URL}/${now_playing?.backdropPath}",
                                    modifier = Modifier
                                        .height(200.dp)
                                        .width(130.dp)
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
    }
}
