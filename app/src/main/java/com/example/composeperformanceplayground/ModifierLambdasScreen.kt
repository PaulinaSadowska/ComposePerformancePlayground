package com.example.composeperformanceplayground

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun ModifierLambdasScreen() {
    val scrollState = rememberScrollState()
    Box {
        ScrollingArea(scrollState)
        HorizontallyMovingButton{
            scrollState.value * 1.5f
        }
    }
}

@Composable
private fun ScrollingArea(scrollState: ScrollState) {
    Spacer(modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .height(2000.dp))
}

@Composable
private fun HorizontallyMovingButton(scrollProvider: () -> Float) {
    Button(modifier = Modifier.graphicsLayer { translationY = scrollProvider() }, onClick = {}) {
        Text(text = "button")
    }
}