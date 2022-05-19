package com.alexmumo.movies.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun FavoriteUI(
    modifier: Modifier = Modifier,
    movie: MovieEntity
) {
    AnimatedVisibility(
        visible = true,
        enter = fadeIn(),
        exit = shrinkOut()
    ) {
        Card(
            modifier = modifier
                .animateContentSize()
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row {
                FavoriteCard(
                    movie = movie,
                    modifier = Modifier.fillMaxWidth(0.35f)
                )
                Spacer(modifier = Modifier.size(8.dp))
                FavoriteInfo(
                    movie = movie,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun FavoriteCard(
    modifier: Modifier,
    movie: MovieEntity
) {
    CoilImage(
        imageRequest = ImageRequest
            .Builder(LocalContext.current)
            .data(movie.movieImage)
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
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun FavoriteInfo(
    movie: MovieEntity,
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
            text = movie.title,
            color = Color.DarkGray,
            style = MaterialTheme.typography.caption,
            maxLines = 1,

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.title,
            color = Color.Blue,
            style = MaterialTheme.typography.caption,
            maxLines = 1
        )
    }
}
