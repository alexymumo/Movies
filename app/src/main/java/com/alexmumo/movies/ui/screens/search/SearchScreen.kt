package com.alexmumo.movies.ui.screens.search

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.navigation.NavController

@Composable
fun SearchScreen(
    navController: NavController
) {
    var text by remember { mutableStateOf("")}
    OutlinedTextField(
        value = text,
        onValueChange = { text = it }
    )
}
