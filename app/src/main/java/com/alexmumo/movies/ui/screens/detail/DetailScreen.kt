package com.alexmumo.movies.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.movies.ui.common.Constants
import com.alexmumo.movies.ui.components.DetailCard
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
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Green
                    )
                }
                item {
                    Text(
                        text = "Release Date: ${moviedetail.data?.releaseDate}",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Green
                    )
                }
                item {
                    Text(
                        text = moviedetail.data?.overview.toString()
                    )
                }
            }
        }
    }
}
