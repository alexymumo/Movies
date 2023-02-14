package com.alexmumo.movies.ui.screens.cast

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmumo.movies.R

@ExperimentalFoundationApi
@Composable
fun CastScreen() {
    Scaffold(
        topBar = {
            Text(
                text = "Cast",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(20.dp),
                content = {
                    items(20) {
                        CastItem()
                    }
                })
        }
    }
}



@Composable
fun CastItem() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.playstore),
            contentDescription = "cast_image",
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "Alex Mumo",
            fontWeight = FontWeight.Bold
        )
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun CastItemPreview() {
    CastScreen()
}

/*
cast: Cast,
navController: NavController
*/