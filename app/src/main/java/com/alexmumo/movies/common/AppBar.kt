package com.alexmumo.movies.common

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Movies",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        },
        contentColor = Color.White,
        elevation = 10.dp,
        backgroundColor = Color.Cyan,
        modifier = Modifier.height(60.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar()
}
