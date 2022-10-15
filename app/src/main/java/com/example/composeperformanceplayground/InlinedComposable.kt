package com.example.composeperformanceplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun StateReadsInlinedComposablesScreen() {
    var count by remember { mutableStateOf(0) }

    WrappedColumn {
        Text(text = "count: $count")
        Button(onClick = { count++ }) {
            Text(text = "count++")
        }
    }
}

@Composable
fun WrappedColumn(content: @Composable ColumnScope.() -> Unit) {
    Column(content = content)
}


@Composable
fun StateReadsInlinedComposablesSolution2Screen() {
    var count by remember { mutableStateOf(0) }
    Column {
        TextWrapper(provideCount = { count })
        Button(onClick = { count++ }) {
            Text(text = "V2 - count++")
        }
    }
}
@Composable
fun TextWrapper(provideCount: () -> Int) {
    Text(text = "Count: ${provideCount()}")
}