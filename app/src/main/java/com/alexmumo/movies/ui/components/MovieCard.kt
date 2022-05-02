package com.alexmumo.movies.ui.components

// ktlint-disable no-wildcard-imports
// ktlint-disable no-wildcard-imports
import androidx.compose.animation.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import coil.request.ImageRequest
import com.alexmumo.network.models.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun MovieCard(
    movieString: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            var palette by remember { mutableStateOf<Palette?>(null) }
            CoilImage(
                imageRequest = ImageRequest
                    .Builder(LocalContext.current)
                    .data(movieString)
                    .crossfade(true)
                    .build(),
                bitmapPalette = BitmapPalette {

                    palette = it
                },
                alignment = Alignment.Center,
                modifier = modifier
                    .aspectRatio(0.8f),
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = Color.Green,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
               /* loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },

                */
                circularReveal = CircularReveal(
                    duration = 300,
                ),
                failure = {
                    Text(text = "Image failed to load")
                },
                contentScale = ContentScale.Crop
            )
            Crossfade(
                targetState = palette,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(45.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color(it?.lightVibrantSwatch?.rgb ?:0))
                        .fillMaxSize()
                )
            }
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
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = alignment
    ) {
        Text(
            text = movie.releaseDate!!,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.originalTitle!!,
            color = Color.DarkGray,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold
        )
    }
}

/*

@Composable
fun PopularMovieItem(
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
                MovieCard(
                    movieString = "$IMAGE_URL/${movie.backdropPath}",
                    modifier = Modifier
                        .fillMaxWidth(0.35f)
                )
                Spacer(modifier = Modifier.size(8.dp))
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


 */
