package com.alexmumo.movies.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.alexmumo.domain.models.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PopularMoviesCard(
    movieString: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(300.dp)
            .width(200.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            CoilImage(
                imageRequest = ImageRequest
                    .Builder(LocalContext.current)
                    .crossfade(true)
                    .build(),
                alignment = Alignment.Center,
                loading = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                circularReveal = CircularReveal(
                    duration = 300,
                ),
                failure = {
                    Text(text = "Image failed to load")
                },
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun MovieInfo(
    movie: Movie,
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = alignment
    ) {
        Text(
            text = movie.releaseDate!!,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun PopularMoviesUI(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Bottom
        ) + fadeIn(
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkHorizontally() + fadeOut()
    ) {
        Card(
            modifier = modifier
                .animateContentSize()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row {
                PopularMoviesCard(
                    movieString = movie.backdropPath!!,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                MovieInfo(
                    movie = movie,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}
