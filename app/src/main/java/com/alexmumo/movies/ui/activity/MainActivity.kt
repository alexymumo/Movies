package com.alexmumo.movies.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexmumo.movies.ui.common.AppBar
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
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            AppBar()
                        },
                        content = {
                            MainScreen()
                        }
                    )
                }
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
