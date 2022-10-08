package com.example.composeperformanceplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jayasuryat.dowel.annotation.Dowel

// Playground to find out if it's worth using Dowel
// it generates new values on build so
// I get different preview all the time

@Composable
fun UserTile(user: User) {
    Row(Modifier.background(Color.White)) {
        if (user.type == User.UserType.Vip) {
            Text("I'm a VIP of age ${user.age}")
        } else {
            Text("I'm regular peasant")
        }
        Text("My name is ${user.name}")
    }
}

@Preview
@Composable
fun UserTilePreview() {
    Column {
        UserPreviewParamProvider().values.forEach {
            UserTile(it)
        }
    }
}

@Dowel(count = 2)
data class User(
        val name: String,
        val surname: String,
        val age: Int,
        val type: UserType
) {
    enum class UserType { Vip, Standard }
}