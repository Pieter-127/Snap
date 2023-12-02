package com.pieterv.snap.presentation.nav.content

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface SwappableContent {
    @Composable
    fun Content(modifier: Modifier)
}
