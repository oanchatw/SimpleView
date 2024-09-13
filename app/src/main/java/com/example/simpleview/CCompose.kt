package com.example.simpleview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CCompose() {

    Column {
        Text("AAAAA", modifier = Modifier.padding( vertical = 20.dp).background(Color.Blue))
        Text("BBBB", modifier = Modifier.padding(vertical = 50.dp).background(Color.Red))
        Text("CCCCC", modifier = Modifier.padding(vertical = 50.dp).background(Color.Yellow))
    }


}