package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.request.ImageRequest
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
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                    width = Dimension.fillToConstraints
                }
                .aspectRatio(2f / 3f),
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
        Text(
            text = "Alex",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(movieOverview) {
                start.linkTo(movieImage.end, 16.dp)
            }
        )
        Text(
            text = "Date",

        )
    }
}

@Preview
@Composable
fun MovieDetailsPreview() {
}
