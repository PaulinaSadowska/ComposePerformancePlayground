package com.example.composeperformanceplayground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun UnstableListScreen() {
    val items = remember { (0..100).map { it }.toMutableList() }
    Box {
        WrappedLazyColumn(items = items)
    }
}

@Composable
private fun WrappedLazyColumn(items: MutableList<Int>) {
    val checked = remember { mutableStateOf(false) }
    LazyColumn {
        items(items = items, key = { item -> item }) { item ->
            Text(text = "item $item")
            RadioButton(selected = checked.value, onClick = { checked.value = !checked.value })
        }
    }
}