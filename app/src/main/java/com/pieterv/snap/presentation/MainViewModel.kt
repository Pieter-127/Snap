package com.pieterv.snap.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(MainScreenState())
        private set

    fun onEvent(event: ScreenEvent) {
        when (event) {
            is ScreenEvent.BottomNavChanged -> {
                if (event.newScreen in state.navigationItems.map { it.type }) {
                    val selectedIndex = state.navigationItems.indexOfFirst { it.type == event.newScreen }
                    state = state.copy(
                        selectedPageIndex = selectedIndex,
                        selectedPageType = event.newScreen,
                    )
                }
            }
        }
    }
}
