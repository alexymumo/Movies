package com.alexmumo.movies.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexmumo.domain.models.responses.CastResponse
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.movies.ui.common.Constants
import com.alexmumo.movies.ui.components.DetailCard
import com.alexmumo.movies.ui.components.MovieVote
import com.alexmumo.repository.util.Resource
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    detailViewModel: DetailViewModel = getViewModel(),
    movieId: Int
) {
    val context = LocalContext.current
    val moviedetail = produceState<Resource<MovieDetailResponse>>(initialValue = Resource.Loading()) {
        value = detailViewModel.fetchMovieDetails(movieId)
    }.value

    val moviecasts = produceState<Resource<CastResponse>>(initialValue = Resource.Loading()) {
        value = detailViewModel.fetchMovieCasts(movieId)
    }.value

    Box {
        if (moviedetail is Resource.Success) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    DetailCard(
                        imageString = "${Constants.IMAGE_URL}/${moviedetail.data?.posterPath}",
                        date = moviedetail.data?.releaseDate.toString(),
                        movieId = moviedetail.data?.id!!,
                        title = moviedetail.data?.title.toString(),
                        time = moviedetail.data?.releaseDate.toString()
                    )
                }

                item {
                    Text(
                        text = "Title: ${moviedetail.data?.title}",
                        fontWeight = FontWeight.Bold,
                        color = Color.Green,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(
                            horizontal = 10.dp
                        )
                    )
                }
                item {
                    Text(
                        text = "Release Date: ${moviedetail.data?.releaseDate}",
                        fontWeight = FontWeight.Bold,
                        color = Color.Green,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(
                            horizontal = 10.dp
                        )
                    )
                }
                item {
                    Text(
                        text = moviedetail.data?.overview.toString(),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(
                            horizontal = 10.dp
                        )
                    )
                }
                item {
                    MovieVote(
                        voteAverage = moviedetail.data?.popularity?.toFloat()!!
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 10.dp
                        ),
                        text = "Cast",
                        style = MaterialTheme.typography.h6,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                    }
                }
            }
        }
    }
}
