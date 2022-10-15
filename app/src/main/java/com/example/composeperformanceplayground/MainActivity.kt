package com.example.composeperformanceplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeperformanceplayground.ui.theme.ComposePerformancePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePerformancePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = hiltViewModel<TypicalViewModel>()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Android")
                        val checked = remember { mutableStateOf(false) }
                        RadioButton(selected = checked.value, onClick = {
                            viewModel.increaseCounter()
                            checked.value = !checked.value
                        })
                        UnstableClassUsageScreen()
                        StateReadsInlinedComposablesScreen()
                        StateReadsInlinedComposablesSolution2Screen()
                        UnstableListScreen()
                        UnstableLambdaScreen()
                        UnstableLambdaScreenV2 {
                            viewModel.onContinueClick()
                        }
                        UnstableLambdaScreenV3 {
                            viewModel.onContinueClick()
                        }
                        StableLambdaScreen()
                        val stableLambda = remember(viewModel) {
                            { viewModel.onContinueClick() }
                        }
                        StableLambdaScreenV2(stableLambda)
                        UnstableLambdaScreenV4 {
                            viewModel.onContinueClick()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePerformancePlaygroundTheme {
        Greeting("Android")
    }
}