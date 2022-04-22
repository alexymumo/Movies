package com.alexmumo.movies.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import coil.request.ImageRequest
import com.alexmumo.domain.models.Movie
import com.alexmumo.movies.screens.home.HomeViewModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PopularMoviesCard(
    modifier: Modifier = Modifier,
    movieString: String,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        CoilImage(
            imageRequest = ImageRequest.Builder(
                LocalContext.current
            )
                .data(movieString)
                .crossfade(true)
                .build(),
            alignment = Alignment.Center,
            circularReveal = CircularReveal(duration = 350),
            loading = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        )
    }
}

@Composable
fun PopularMoviesCard(
    onClickItem: (Movie) -> Unit,
    movie: Movie,
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(300.dp)
            .height(300.dp)
            .clickable {
                onClickItem(movie)
            },
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout() {

        }
    }
}
