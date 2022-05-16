package com.alexmumo.movies.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.movies.ui.common.AppBar

@Composable
fun SearchScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AppBar(
            navController = navController,
            title = {
                Column {
                    Text(
                        text = "Search",
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true
        )
    }
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth()
    )
}
