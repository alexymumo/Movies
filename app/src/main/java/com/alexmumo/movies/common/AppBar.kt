package com.alexmumo.movies.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar() {
    TopAppBar(
        elevation = 10.dp,
        backgroundColor = Color.Cyan,
        modifier = Modifier.height(60.dp)
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Image(
            imageVector = Icons.Filled.ArrowBack,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.align(Alignment.CenterVertically),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = "Movies",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar()
}
