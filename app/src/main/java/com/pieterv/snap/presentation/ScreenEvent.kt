package com.pieterv.snap.presentation

import com.pieterv.snap.presentation.nav.BottomNavType

sealed class ScreenEvent {
    data class BottomNavChanged(val newScreen: BottomNavType) : ScreenEvent()
}
