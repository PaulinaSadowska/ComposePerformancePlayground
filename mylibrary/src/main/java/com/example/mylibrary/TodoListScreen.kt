package com.example.mylibrary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoListScreen() {
    Column(
            modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(8.dp)
    ) {
        LazyColumn(
                modifier = Modifier.padding(top = 4.dp)
        ) {
            items(listOf("Lorem", "Ipsum", "Dolorem", "...")) { element ->
                TaskItem(modifier = Modifier.padding(8.dp), task = element)
            }
        }
    }
}