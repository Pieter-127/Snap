package com.pieterv.snap.presentation

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class MainContentSnapshot {

    @get: Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_5,
    )

    @Test
    fun loginScreenSnapshot() {
        paparazzi.snapshot {
            MainScreenContent {
            }
        }
    }
}
