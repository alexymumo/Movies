package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LikeCard(
    onPress: (checkFavorite: Boolean) -> Unit = {},
    liked: Boolean
) {
    IconButton(onClick = {
        onPress(liked)
    }) {
        Icon(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            imageVector = Icons.Filled.Favorite,
            contentDescription = null
        )
    }
}
