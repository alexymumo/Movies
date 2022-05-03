package com.alexmumo.movies.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.alexmumo.movies.ui.screens.detail.DetailViewModel
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailCard(
    imageString: String,
    movieId: Int,
    date: String,
    title: String,
    modifier: Modifier = Modifier,
    // movieDetail: MovieDetailResponse,
    viewModel: DetailViewModel = getViewModel(),
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {
        val (movieImage, movieOverview, boxFadingEdge, movieTime, movieTitle) = createRefs()
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
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
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent
                        )
                    )
                )
                .constrainAs(boxFadingEdge) {
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = date,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(movieOverview) {
                    start.linkTo(movieTitle.end)
                    bottom.linkTo(movieTitle.top)
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
    }
}
