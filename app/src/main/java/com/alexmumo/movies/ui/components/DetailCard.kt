package com.alexmumo.movies.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.movies.ui.screens.favorite.FavoriteViewModel
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailCard(
    imageString: String,
    movieId: Int,
    vote: Float,
    time: String,
    date: String,
    movieOverview: String,
    title: String,
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = getViewModel()
) {
    val context = LocalContext.current
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
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
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
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
        MovieVote(
            voteAverage = vote,
            modifier = Modifier.fillMaxSize(0.17f)
        )
        Text(
            text = "Release Date: $time",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(movieDate) {
                    start.linkTo(movieTitle.start)
                    bottom.linkTo(movieTitle.top)
                }
        )
        Text(
            text = title,
            color = Color.Green,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(movieTitle) {
                start.linkTo(parent.start, margin = 5.dp)
                end.linkTo(parent.end, margin = 5.dp)
                bottom.linkTo(parent.bottom, margin = 5.dp)
            }
        )
        Row {
            LikeCard(
                liked = viewModel.checkFavorite(movieId).observeAsState().value != null,
                onPress = { isLiked ->
                    if (isLiked) {
                        Toast.makeText(context, "Already Liked", Toast.LENGTH_LONG).show()
                    } else {
                        viewModel.saveMovie(
                            MovieEntity(
                                movieID = movieId,
                                movieImage = imageString,
                                releaseDate = date,
                                title = title,
                                like = true
                            )
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun MoviePoster(
    navController: NavController,
    movieImage: String,
    movieDate: String,
    movieRating: Float,
    movieId: Int,
    movieName: String,
    movieRuntime: String,
    viewModel: FavoriteViewModel = getViewModel()
) {
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.Green
    ) {
        Column {
            Box {
                CoilImage(
                    imageRequest = ImageRequest
                        .Builder(LocalContext.current)
                        .data(movieImage)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .fillMaxSize(),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.3f, Transparent)
                                )
                            )
                        )
                )
                MovieVote(
                    voteAverage = movieRating
                )
            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    ) {
        CustomBackButton(
            onClick = {
                navController.popBackStack()
            }
        )
        LikeCard(
            liked = viewModel.checkFavorite(movieId).observeAsState().value != null,
            onPress = { isLiked ->
                if (isLiked) {
                   // Toast.makeText(context, "Already Liked", Toast.LENGTH_LONG).show()
                } else {
                    viewModel.saveMovie(
                        MovieEntity(
                            movieID = movieId,
                            movieImage = movieImage,
                            releaseDate = movieDate,
                            title = movieName,
                            like = true
                        )
                    )
                }
            }
        )

    }
}
