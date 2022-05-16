package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun DetailCard(
    imageString: String,
    movieId: Int,
    vote: String,
    date: String,
    movieOverview: String,
    title: String,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        val (movieImage, movieDescription, boxFadingEdge, movieTitle, movieDate, movieVote) = createRefs()
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
                .data(imageString)
                .build(),
            alignment = Alignment.Center,
            modifier = modifier
                .constrainAs(movieImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .constrainAs(boxFadingEdge) {
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = movieOverview,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(movieDescription) {
                    bottom.linkTo(movieImage.bottom)
                }
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(movieTitle) {
                    start.linkTo(movieTitle.end)
                    bottom.linkTo(movieTitle.top)
                }
        )
        Text(
            text = date,
            color = Color.Green,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(movieDate) {
                start.linkTo(movieImage.end)
            }
        )
        Text(
            text = vote,
            color = Color.Yellow,
            modifier = Modifier.constrainAs(movieVote) {
                start.linkTo(movieTitle.end)
            }

        )
    }
}
