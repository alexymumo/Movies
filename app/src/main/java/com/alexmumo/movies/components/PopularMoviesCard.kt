package com.alexmumo.movies.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.alexmumo.domain.models.Movie
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PopularMoviesCard(
    onClickItem: (Movie) -> Unit,
    movie: Movie,
    movieString: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(300.dp)
            .width(200.dp)
            .clickable { onClickItem(movie) },
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (movieImage, movieTitle) = createRefs()

            CoilImage(
                imageRequest = ImageRequest
                    .Builder(LocalContext.current)
                    .data(movieString)
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
            Box() {

            }
        }
    }
}
