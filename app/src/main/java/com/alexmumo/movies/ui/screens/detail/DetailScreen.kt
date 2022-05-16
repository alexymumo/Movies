package com.alexmumo.movies.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
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
    val moviedetail = produceState<Resource<MovieDetailResponse>>(initialValue = Resource.Loading()) {
        value = detailViewModel.fetchMovieDetails(movieId)
    }.value

    Box {
        if (moviedetail is Resource.Success) {
            DetailCard(
                imageString = "${Constants.IMAGE_URL}/${moviedetail.data?.posterPath}",
                date = moviedetail.data?.releaseDate.toString(),
                movieId = moviedetail.data?.id!!,
                vote = moviedetail.data?.voteCount.toString(),
                title = moviedetail.data?.title.toString(),
                movieOverview = moviedetail.data?.overview.toString()
            )
        } else {
            CircularProgressIndicator()
        }
    }
}
