package com.pieterv.snap.presentation.nav

import androidx.compose.ui.graphics.vector.ImageVector

typealias StringResourceID = Int

data class BottomNavigationItem(
    val title: StringResourceID,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNotification: Boolean = false,
    val badgeCount: Int? = null,
    val type: BottomNavType,
)

enum class BottomNavType {
    HOME,
    SNAP,
    NOTIFICATIONS,
}
