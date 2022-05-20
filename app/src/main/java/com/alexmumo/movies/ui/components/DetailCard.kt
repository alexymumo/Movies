package com.alexmumo.movies.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.movies.ui.screens.favorite.FavoriteViewModel
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailCard(
    imageString: String,
    movieId: Int,
    time: String,
    date: String,
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
        val (movieImage, boxFadingEdge) = createRefs()
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
        Row(
            modifier = Modifier.padding(
                horizontal = 150.dp
            )
        ) {
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