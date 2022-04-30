package com.alexmumo.movies.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import coil.request.ImageRequest
import com.alexmumo.movies.ui.common.Constants.IMAGE_URL
import com.alexmumo.network.models.MovieDto
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun MovieCard(
    movieString: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(250.dp)
            .width(250.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            var palette by remember { mutableStateOf<Palette?>(null) }
            CoilImage(
                modifier = modifier
                    .height(250.dp)
                    .width(250.dp),
                imageRequest = ImageRequest
                    .Builder(LocalContext.current)
                    .data(movieString)
                    .crossfade(true)
                    .build(),
                alignment = Alignment.Center,
                bitmapPalette = BitmapPalette {
                    palette = it
                },
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
    movie: MovieDto,
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = alignment
    ) {
        Text(
            text = movie.releaseDate!!,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = movie.originalTitle!!,
            color = Color.DarkGray
        )
    }
}

@Composable
fun PopularMovieItem(
    movie: MovieDto?,
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
                if (movie != null) {
                    MovieCard(
                        movieString = "$IMAGE_URL/${movie.backdropPath}",
                        modifier = Modifier
                            .fillMaxWidth(0.35f)
                    )
                }
                Spacer(modifier = Modifier.size(8.dp))
                if (movie != null) {
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
}
