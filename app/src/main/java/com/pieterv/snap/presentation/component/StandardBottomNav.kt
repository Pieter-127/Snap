package com.pieterv.snap.presentation.component

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.pieterv.snap.presentation.nav.BottomNavType
import com.pieterv.snap.presentation.nav.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardBottomNav(
    modifier: Modifier = Modifier,
    selectedItemIndex: Int = 1,
    items: List<BottomNavigationItem>,
    onTap: (type: BottomNavType) -> Unit,
) {
    NavigationBar(modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    onTap(item.type)
                },
                label = {
                    Text(text = stringResource(id = item.title))
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNotification) {
                                Badge(modifier = Modifier.testTag("${item.title}_emptyTag"))
                            }
                        },
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else {
                                item.unselectedIcon
                            },
                            contentDescription = stringResource(id = item.title),
                        )
                    }
                },
            )
        }
    }
}
