package com.alexmumo.movies.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieCard(
    movieString: String,
    modifier: Modifier = Modifier
) {
    val visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            expandFrom = Alignment.Bottom
        ) + fadeIn(
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ) {
        Card(
            modifier = modifier
                .animateContentSize()
                .padding(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                CoilImage(
                    imageRequest = ImageRequest
                        .Builder(LocalContext.current)
                        .data(movieString)
                        .crossfade(true)
                        .build(),
                    alignment = Alignment.Center,
                    modifier = modifier
                        .aspectRatio(0.8f),
                    loading = {
                        Box(modifier = Modifier.matchParentSize()) {
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
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
