package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.request.ImageRequest
import com.alexmumo.domain.models.Cast
import com.alexmumo.movies.R
import com.alexmumo.movies.ui.common.Constants
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CastCard(
    modifier: Modifier = Modifier,
    cast: Cast
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(70.dp),
            imageModel = "",
            contentScale = ContentScale.Crop,
            contentDescription = "Cast")
    }
}
