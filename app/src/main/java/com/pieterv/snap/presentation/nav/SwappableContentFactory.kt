package com.pieterv.snap.presentation.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pieterv.snap.presentation.nav.content.Home
import com.pieterv.snap.presentation.nav.content.Notification
import com.pieterv.snap.presentation.nav.content.Snap
import com.pieterv.snap.presentation.nav.content.SwappableContent

@Composable
fun SwappableContentFactory(type: BottomNavType, paddingValues: PaddingValues) {
    val standardModifier = Modifier
        .padding(paddingValues)
        .fillMaxSize()

    createContentForType(type).Content(modifier = standardModifier)
}

@Composable
private fun createContentForType(type: BottomNavType): SwappableContent {
    return when (type) {
        BottomNavType.HOME -> object : SwappableContent {
            @Composable
            override fun Content(modifier: Modifier) {
                Home().Content(modifier = modifier)
            }
        }

        BottomNavType.SNAP -> object : SwappableContent {
            @Composable
            override fun Content(modifier: Modifier) {
                Snap().Content(modifier = modifier)
            }
        }

        BottomNavType.NOTIFICATIONS -> object : SwappableContent {
            @Composable
            override fun Content(modifier: Modifier) {
                Notification().Content(modifier = modifier)
            }
        }
    }
}
