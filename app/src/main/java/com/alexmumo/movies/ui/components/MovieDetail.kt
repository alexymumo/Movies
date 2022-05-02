package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.request.ImageRequest
import com.alexmumo.movies.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieDetails(
    movieString: String,
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (movieOverview, movieImage, movieVideo, movieDate, movieStatus, voteCount) = createRefs()
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
                .data(movieString)
                .crossfade(true)
                .build(),
            alignment = Alignment.Center,
            modifier = Modifier
                .constrainAs(movieImage) {
                    start.linkTo(parent.start, 20.dp)
                    width = Dimension.fillToConstraints
                }
            ,
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
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
fun MovieDetailsPreview() {
}
