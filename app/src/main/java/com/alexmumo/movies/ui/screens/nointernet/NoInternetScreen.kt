package com.alexmumo.movies.ui.screens.nointernet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexmumo.movies.R
import com.alexmumo.movies.activity.MainActivity
import com.alexmumo.movies.ui.screens.main.MainScreen

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun NoInternetScreen(
    context: Context
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.four),
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            color = Color.DarkGray,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.found),
            color = Color.Magenta,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.internet),
            color = Color.Gray,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {
                val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo: NetworkInfo? = connectionManager.activeNetworkInfo
                val isMobileConnected: Boolean = networkInfo?.isConnected == true
                if (isMobileConnected) {
                    (context as MainActivity).setContent {
                        MainScreen()
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.try_again),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun NoInternetScreenPreview() {
    //NoInternetScreen()
}