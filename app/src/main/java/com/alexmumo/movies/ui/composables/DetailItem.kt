package com.alexmumo.movies.ui.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailItem() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)
        ) {
            Image(
                painter = painterResource(id = com.alexmumo.movies.R.drawable.playstore),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "The Way of Water",
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "Lorem ipsum dolor sit amet, adipiscing, sed")
    }
}


@Preview
@Composable
fun DetailItemPreview() {
    DetailItem()
}