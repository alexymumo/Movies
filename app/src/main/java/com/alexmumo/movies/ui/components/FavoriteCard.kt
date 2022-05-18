package com.alexmumo.movies.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun FavoriteCard(
    movie: MovieEntity
) {
    Box {
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
                .data(movie.movieImage)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier.fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colorStops = arrayOf(
                            Pair(0.3f, Transparent),
                            Pair(1.5f, Transparent)
                        )
                    )
                )
        )
        FavoriteDetails(
            movieTitle = movie.title,
            movieRelease = movie.releaseDate
        )
    }
}
@Composable
fun FavoriteDetails(
    movieTitle: String,
    movieRelease: String
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 5.dp, horizontal = 5.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column {
            Text(
                text = movieTitle,
                color = Color.Green
            )
            Text(
                text = movieRelease,
                color = Color.Blue
            )
        }
    }
}
