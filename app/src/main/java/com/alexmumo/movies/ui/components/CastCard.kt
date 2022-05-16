package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CastCard(
    castUrl: String,
    castName: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            imageRequest = ImageRequest
                .Builder(LocalContext.current)
                .data(castUrl)
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
            contentScale = ContentScale.Crop,
            contentDescription = "Cast"
        )
        Text(
            text = castName,
            maxLines = 1,
            color = Color.Green,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic
        )
    }
}
