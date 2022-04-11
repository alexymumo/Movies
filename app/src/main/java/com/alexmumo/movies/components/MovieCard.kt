package com.alexmumo.movies.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.request.ImageRequest
import com.alexmumo.domain.models.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieCard(
    imageLink: String,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
                .data(imageLink)
                .crossfade(true)
                .build(),
            alignment = Alignment.Center,
            circularReveal = CircularReveal(duration = 200),
            failure = {
                Text(text = "Failed to load image")
            }
        )
    }
}

@Composable
fun MovieUI(movie: Movie, modifier: Modifier = Modifier) {
    Row {
        MovieCard(
            imageLink = movie.backdropPath!!,
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun MovieGrid(
    items: LazyPagingItems<Movie>,
    gridState: LazyGridState = rememberLazyGridState(),
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), state = gridState) {
        items(items.itemCount) { index ->
            items[index]?.let {
                MovieUI(movie = it)
            }
        }
    }
}
