package com.pieterv.snap.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.pieterv.snap.R
import com.pieterv.snap.presentation.component.StandardBottomNav
import com.pieterv.snap.presentation.nav.BottomNavType
import com.pieterv.snap.presentation.nav.BottomNavigationItem
import com.pieterv.snap.presentation.nav.SwappableContentFactory

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    MainScreenContent(viewModel.state) {
        viewModel.onEvent(it)
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreenContent(
        state = MainScreenState(
            selectedPageIndex = 0,
            navigationItems = listOf(
                BottomNavigationItem(
                    title = R.string.nav_home_title,
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    type = BottomNavType.HOME,
                ),
            ),
            selectedPageType = BottomNavType.HOME,
        ),
    ) {}
}

@Composable
fun MainScreenContent(state: MainScreenState = MainScreenState(), event: (ScreenEvent) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Scaffold(
            bottomBar = {
                StandardBottomNav(
                    selectedItemIndex = state.selectedPageIndex,
                    items = state.navigationItems,
                ) {
                    event(ScreenEvent.BottomNavChanged(it))
                }
            },
        ) { paddingValue ->
            SwappableContentFactory(state.selectedPageType, paddingValue)
        }
    }
}
