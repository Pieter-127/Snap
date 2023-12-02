package com.pieterv.snap.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pieterv.snap.presentation.navigation.Navigation
import com.pieterv.snap.ui.theme.SnapTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnapTheme {
                Navigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    SnapTheme {
        MainScreenContent(state = MainScreenState()) {}
    }
}
