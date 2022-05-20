package com.alexmumo.movies.ui.screens.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexmumo.movies.ui.components.AppBar
import com.alexmumo.movies.ui.components.FavoriteUI
import org.koin.androidx.compose.getViewModel

@Composable
fun FavoriteScreen(
    navController: NavController,
    viewModel: FavoriteViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val liked = viewModel.likedMovies.observeAsState(initial = emptyList())
        AppBar(
            navController = navController,
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            title = {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace,
                    text = "Liked Movies",
                    color = Color.Green
                )
            }
        )

        LazyColumn {
            items(items = liked.value) { liked ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate("details/${liked.movieID}")
                        }
                ) {
                    FavoriteUI(
                        movie = liked
                    )
                }
            }
        }
    }
}

