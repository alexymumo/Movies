package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    }
}
