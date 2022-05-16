package com.alexmumo.movies.ui.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ToolBar(
    navController: NavController,
    showActionBar: Boolean = false,
    navAction: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
}
