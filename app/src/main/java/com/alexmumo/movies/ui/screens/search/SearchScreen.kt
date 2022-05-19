package com.alexmumo.movies.ui.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.movies.ui.common.AppBar
import com.alexmumo.movies.ui.common.SearchBar
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel(),
    navController: NavController,
) {
    val search = viewModel.searchString.value
    Column(
        modifier = Modifier.fillMaxSize()
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
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
    }
}