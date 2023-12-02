package com.pieterv.snap.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PhotoCamera
import com.pieterv.snap.R
import com.pieterv.snap.presentation.nav.BottomNavType
import com.pieterv.snap.presentation.nav.BottomNavigationItem

object MainBottomNavigationItems {

    fun getMainScreenItems() =
        listOf(
            BottomNavigationItem(
                title = R.string.nav_home_title,
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
                type = BottomNavType.HOME,
            ),
            BottomNavigationItem(
                title = R.string.nav_snap_title,
                selectedIcon = Icons.Filled.PhotoCamera,
                unselectedIcon = Icons.Outlined.PhotoCamera,
                badgeCount = 3,
                type = BottomNavType.SNAP,
            ),
            BottomNavigationItem(
                title = R.string.nav_notifications_title,
                selectedIcon = Icons.Filled.Notifications,
                unselectedIcon = Icons.Outlined.Notifications,
                hasNotification = true,
                type = BottomNavType.NOTIFICATIONS,
            ),
        )
}
