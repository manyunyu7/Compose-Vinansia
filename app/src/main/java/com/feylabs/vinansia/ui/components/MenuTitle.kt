package com.feylabs.vinansia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.feylabs.vinansia.ui.font.interFontFamily

@Composable
fun MenuTitle(modifier: Modifier = Modifier, title: String = "") {
    Column(modifier) {
        Text(title, fontFamily = interFontFamily, fontSize = 15.sp)
    }
}

@Preview
@Composable
fun MenuTitlePreview() {
    MenuTitle(title = "Unboxing Saham")
}