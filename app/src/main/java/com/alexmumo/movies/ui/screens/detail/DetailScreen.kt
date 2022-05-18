package com.alexmumo.movies.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.domain.models.responses.MovieDetailResponse
import com.alexmumo.movies.ui.components.MoviePoster
import com.alexmumo.repository.util.Resource
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(
    navController: NavController,
    detailViewModel: DetailViewModel = getViewModel(),
    movieId: Int
) {
    val moviedetail = produceState<Resource<MovieDetailResponse>>(initialValue = Resource.Loading()) {
        value = detailViewModel.fetchMovieDetails(movieId)
    }.value

    Box {
        if (moviedetail is Resource.Success) {
            MoviePoster(
                navController = navController,
                movieImage = "{Constants.IMAGE_URL}/${moviedetail.data?.posterPath}",
                movieDate = moviedetail.data?.releaseDate.toString(),
                movieRuntime = moviedetail.data?.overview.toString(),
                movieName = moviedetail.data?.title.toString(),
                movieId = moviedetail.data?.id!!,
                movieRating = moviedetail.data?.voteAverage?.toFloat()!!
            )
            /*moviedetail.data?.voteCount?.let {
                DetailCard(
                    imageString = "${Constants.IMAGE_URL}/${moviedetail.data?.posterPath}",
                    date = moviedetail.data?.releaseDate.toString(),
                    movieId = moviedetail.data?.id!!,
                    vote = it.toFloat(),
                    title = moviedetail.data?.title.toString(),
                    movieOverview = moviedetail.data?.overview.toString(),
                    time = moviedetail.data?.releaseDate.toString()
                )
            }

             */
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
            }
        } else {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
