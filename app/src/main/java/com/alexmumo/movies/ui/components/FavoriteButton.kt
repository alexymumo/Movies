package com.alexmumo.movies.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
            tint = if (liked) {
                Color.Magenta
            } else {
                Color.DarkGray
            },
            contentDescription = null
        )
    }
}

@Composable
fun CustomBackButton(
    color: Color = Color.Magenta,
    onClick: () -> Unit = {},
    elevation: ButtonElevation = ButtonDefaults.elevation()
) {
    Button(
        elevation = elevation,
        shape = CircleShape,
        onClick = { onClick() },
        contentPadding = PaddingValues(),
        modifier = Modifier
            .width(35.dp)
            .height(35.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = color
        )
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null
            )
        }
    }
}
