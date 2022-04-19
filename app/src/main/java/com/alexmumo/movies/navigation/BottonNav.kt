package com.alexmumo.movies.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

@Composable
fun BottomNav(
    modifier: Modifier = Modifier,
    backStackEntryState: State<NavBackStackEntry?>,
    navController: NavController,
    bottomItems: List<NavigationItem>
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Cyan,
        contentColor = Color.White,
        elevation = 0.dp
    ) {
        bottomItems.forEach { item ->
            val isSelected = item.route == backStackEntryState.value?.destination?.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon!!),
                        contentDescription = stringResource(id = item.title)
                    )
                },
                label = { Text(text = stringResource(id = item.title)) },
                unselectedContentColor = Color.Magenta,
                selectedContentColor = Color.Magenta,
                selected = isSelected,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    // BottomNav()
}
