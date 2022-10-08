package com.example.mylibrary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class UserTileScreenshotTest {
    @get:Rule
    val paparazzi = Paparazzi(
            deviceConfig = PIXEL_5,
            theme = "android:Theme.Material.Light.NoActionBar"
    )

    @Test
    fun launchComposable() {
        paparazzi.snapshot {
            TodoListScreen()
        }
    }
}