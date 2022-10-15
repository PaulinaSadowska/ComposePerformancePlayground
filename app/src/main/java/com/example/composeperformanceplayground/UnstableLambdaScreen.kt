package com.example.composeperformanceplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UnstableLambdaScreen(viewModel: TypicalViewModel = hiltViewModel()) {
    Column {
        // button is not skippable due to usage of viewModel.onContinueClick()
        Button(onClick = { viewModel.onContinueClick() }) {
            Text(text = "button with unstable lambda { vm.call() }")
        }
    }
}

@Composable
fun UnstableLambdaScreenV2(onContinueClick: () -> Unit) {
    Column {
        Button(onClick = { onContinueClick() }) {
            Text(text = "button with unstable lambda { call() }")
        }
    }
}


@Composable
fun UnstableLambdaScreenV3(onContinueClick: () -> Unit) {
    Column {
        Button(onClick = onContinueClick) {
            Text(text = "button with unstable lambda call")
        }
    }
}

@Composable
fun UnstableLambdaScreenV4(onContinueClick: () -> Unit) {
    val stableLambda = remember {
        { onContinueClick() }
    }
    Column {
        Button(onClick = { stableLambda() }) {
            Text(text = "button with unstable lambda - remember lambda in composable")
        }
    }
}

@Composable
fun StableLambdaScreen(viewModel: TypicalViewModel = hiltViewModel()) {
    Column {
        Button(onClick = viewModel::onContinueClick) {
            Text(text = "button with stable lambda vm::call")
        }
    }
}

@Composable
fun StableLambdaScreenV2(onContinueClick: () -> Unit) {
    Column {
        Button(onClick = { onContinueClick() }) {
            Text(text = "button with stable lambda - remembered lambda")
        }
    }
}
