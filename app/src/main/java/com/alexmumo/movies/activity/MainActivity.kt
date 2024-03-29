package com.alexmumo.movies.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexmumo.movies.ui.screens.main.MainScreen
import com.alexmumo.movies.ui.theme.MoviesTheme

@ExperimentalFoundationApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                MainScreen()
            }
        }
    }
}
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MainScreen()
}

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MoviesTheme(darkTheme = true) {
        MainScreen()
    }
}
