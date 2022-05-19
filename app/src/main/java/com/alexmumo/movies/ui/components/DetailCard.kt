package com.alexmumo.movies.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.palette.graphics.Palette
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.alexmumo.movies.ui.screens.favorite.FavoriteViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.palette.BitmapPalette
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
        var palette by remember { mutableStateOf<Palette?>(null) }
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
            bitmapPalette = BitmapPalette{
                palette = it
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