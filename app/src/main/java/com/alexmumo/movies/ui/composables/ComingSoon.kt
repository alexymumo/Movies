package com.alexmumo.movies.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ComingSoon() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .wrapContentSize(
                Alignment.Center
            )
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            text = "Coming Soon",
            fontSize = 30.sp,
            color = Color.Magenta,
            fontStyle = FontStyle.Italic
        )
    }
}

@Composable
@Preview
fun ComingSoonPreview() {
    ComingSoon()
}
