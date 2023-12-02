package com.pieterv.snap.presentation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.pieterv.snap.R
import com.pieterv.snap.presentation.component.MainBottomNavigationItems
import com.pieterv.snap.presentation.nav.BottomNavType
import com.pieterv.snap.presentation.nav.BottomNavigationItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var instrumentationContext: Context

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun bottomNavItemsDisplayedWithTitle() {
        val state = MainScreenState(
            navigationItems = MainBottomNavigationItems.getMainScreenItems(),
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }
        state.navigationItems.forEach {
            val expectedTitle = instrumentationContext.resources.getString(it.title)
            composeTestRule.onNodeWithText(expectedTitle, useUnmergedTree = true).assertExists()
        }
    }

    @Test
    fun bottomNavItemWithBadgeCountIsDisplayed() {
        val state = MainScreenState(
            navigationItems =
            listOf(
                BottomNavigationItem(
                    title = R.string.nav_home_title,
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    type = BottomNavType.HOME,
                    badgeCount = 1,
                ),
                BottomNavigationItem(
                    title = R.string.nav_snap_title,
                    selectedIcon = Icons.Filled.PhotoCamera,
                    unselectedIcon = Icons.Outlined.PhotoCamera,
                    type = BottomNavType.SNAP,
                    badgeCount = 2,
                ),
                BottomNavigationItem(
                    title = R.string.nav_notifications_title,
                    selectedIcon = Icons.Filled.Notifications,
                    unselectedIcon = Icons.Outlined.Notifications,
                    type = BottomNavType.NOTIFICATIONS,
                    badgeCount = 3,
                ),
            ),
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }
        state.navigationItems.forEach {
            val expectedBadgeCount = it.badgeCount.toString()
            composeTestRule.onNodeWithText(expectedBadgeCount, useUnmergedTree = true).assertExists()
        }
    }

    @Test
    fun bottomNavItemWithNotificationIsDisplayed() {
        val state = MainScreenState(
            navigationItems =
            listOf(
                BottomNavigationItem(
                    title = R.string.nav_home_title,
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    type = BottomNavType.HOME,
                    hasNotification = true,
                ),
                BottomNavigationItem(
                    title = R.string.nav_snap_title,
                    selectedIcon = Icons.Filled.PhotoCamera,
                    unselectedIcon = Icons.Outlined.PhotoCamera,
                    type = BottomNavType.SNAP,
                    hasNotification = false,
                ),
                BottomNavigationItem(
                    title = R.string.nav_notifications_title,
                    selectedIcon = Icons.Filled.Notifications,
                    unselectedIcon = Icons.Outlined.Notifications,
                    type = BottomNavType.NOTIFICATIONS,
                    hasNotification = true,
                ),
            ),
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }
        state.navigationItems.forEach {
            val hasNotification = it.hasNotification
            if (hasNotification) {
                composeTestRule.onNodeWithTag("${it.title}_emptyTag", useUnmergedTree = true).assertIsDisplayed()
            }
        }
    }

    @Test
    fun confirmContentWhenSelectedScreenIsHome() {
        val state = MainScreenState(
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
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }

        val expectedTitle = instrumentationContext.resources.getString(R.string.home_content_text)
        composeTestRule.onNodeWithText(expectedTitle, useUnmergedTree = true).assertExists()
    }

    @Test
    fun confirmContentWhenSelectedScreenIsSnap() {
        val state = MainScreenState(
            selectedPageIndex = 0,
            navigationItems = listOf(
                BottomNavigationItem(
                    title = R.string.nav_snap_title,
                    selectedIcon = Icons.Filled.PhotoCamera,
                    unselectedIcon = Icons.Outlined.PhotoCamera,
                    badgeCount = 3,
                    type = BottomNavType.SNAP,
                ),
            ),
            selectedPageType = BottomNavType.SNAP,
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }

        val expectedContent = instrumentationContext.resources.getString(R.string.snap_content_text)
        composeTestRule.onNodeWithText(expectedContent).assertExists()

        val buttonContent = instrumentationContext.resources.getString(R.string.button_action_text)
        composeTestRule.onNodeWithText(buttonContent, useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithText(buttonContent, useUnmergedTree = true).performClick()

        val dialogTitleContent = instrumentationContext.resources.getString(R.string.dialog_title)
        composeTestRule.onNodeWithText(dialogTitleContent, useUnmergedTree = true).assertExists()

        val dialogBodyContent = instrumentationContext.resources.getString(R.string.dialog_text)
        composeTestRule.onNodeWithText(dialogBodyContent, useUnmergedTree = true).assertExists()

        val dialogButtonContent = instrumentationContext.resources.getString(R.string.dismiss)
        composeTestRule.onNodeWithText(dialogButtonContent, useUnmergedTree = true).assertExists()
    }

    @Test
    fun confirmContentWhenSelectedScreenIsNotifications() {
        val state = MainScreenState(
            selectedPageIndex = 0,
            navigationItems = listOf(
                BottomNavigationItem(
                    title = R.string.nav_notifications_title,
                    selectedIcon = Icons.Filled.Notifications,
                    unselectedIcon = Icons.Outlined.Notifications,
                    hasNotification = true,
                    type = BottomNavType.NOTIFICATIONS,
                ),
            ),
            selectedPageType = BottomNavType.NOTIFICATIONS,
        )
        composeTestRule.setContent {
            MainScreenContent(state = state, event = {})
        }

        val expectedTitle = instrumentationContext.resources.getString(R.string.notification_content_text)
        composeTestRule.onNodeWithText(expectedTitle, useUnmergedTree = true).assertExists()
    }
}
