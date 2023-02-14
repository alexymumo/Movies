package com.alexmumo.movies.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alexmumo.cache.entity.MovieEntity
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun FavoriteItem(
    movieEntity: MovieEntity
) {
    Column(
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(bottom = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            elevation = 20.dp,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Row{
                Card(
                    modifier = Modifier
                        .height(120.dp)
                        .width(120.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    CoilImage(
                        imageRequest = ImageRequest
                            .Builder(LocalContext.current)
                            .data(movieEntity.movieImage)
                            .crossfade(true)
                            .build(),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = movieEntity.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = movieEntity.releaseDate,
                        fontWeight = FontWeight.Bold,
                        color = Color.Magenta,
                        modifier = Modifier.border(
                            BorderStroke(width = 1.dp, Color.Magenta),
                            shape = RoundedCornerShape(20.dp)
                        ).padding(5.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FavoriteItemPreview() {
    //FavoriteItem()

}

