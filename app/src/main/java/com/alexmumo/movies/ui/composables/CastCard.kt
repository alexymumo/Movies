package com.alexmumo.movies.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.alexmumo.domain.models.Cast
import com.alexmumo.movies.ui.common.Constants.IMAGE_URL
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
            imageModel = "$IMAGE_URL/${cast.profilePath}",
            contentScale = ContentScale.Crop,
            contentDescription = "Cast"
        )
    }
}
