package com.pieterv.snap.presentation

import com.pieterv.snap.presentation.component.MainBottomNavigationItems
import com.pieterv.snap.presentation.nav.BottomNavType
import com.pieterv.snap.presentation.nav.BottomNavigationItem

data class MainScreenState(
    val selectedPageIndex: Int = 0,
    val navigationItems: List<BottomNavigationItem> = MainBottomNavigationItems.getMainScreenItems(),
    val selectedPageType: BottomNavType = navigationItems.first().type,
)
