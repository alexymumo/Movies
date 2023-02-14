package com.alexmumo.movies.ui.composables

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
    overview: String,
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = getViewModel()
) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            shape = RoundedCornerShape(bottomEnd = 5.dp, bottomStart = 5.dp)
        ) {
            CoilImage(
                imageRequest = ImageRequest
                    .Builder(LocalContext.current)
                    .data(imageString)
                    .build(),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = date,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = overview,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Cast",
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
    }
}


/*

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

    }
}

     /*LikeCard(
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
            )*/



 */