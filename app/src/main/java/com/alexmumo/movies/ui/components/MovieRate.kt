package com.alexmumo.movies.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieVote(
    radius: Dp = 20.dp,
    modifier: Modifier = Modifier,
    voteAverage: Float,
    voteMax: Int = 10,
    strokeWidth: Dp = 3.dp,
    animateDuration: Int = 1000,
    animateDelay: Int = 0,
    fontSize: TextUnit = 16.sp
) {
    var animation by remember {
        mutableStateOf(false)
    }
    val currentPercentage = animateFloatAsState(
        targetValue = if (animation) voteAverage else 0f,
        animationSpec = tween(
            durationMillis = animateDuration,
            delayMillis = animateDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animation = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = (360 * (currentPercentage.value * 0.1)).toFloat(),
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = "${(currentPercentage.value * voteMax).toInt()}%",
            fontWeight = FontWeight.SemiBold,
            fontSize = fontSize
        )
    }
}
