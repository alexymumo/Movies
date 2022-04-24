package com.alexmumo.movies.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexmumo.movies.R
import com.alexmumo.movies.ui.navigation.NavigationItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.navigate(NavigationItem.TopRated.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.design_default_color_primary))
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Movies",
            fontFamily = FontFamily.Monospace,
            fontSize = 40.sp,
            color = Color.Magenta,
            fontStyle = FontStyle.Italic
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    // SplashScreen()
}
