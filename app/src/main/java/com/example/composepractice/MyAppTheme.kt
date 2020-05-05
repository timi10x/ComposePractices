package com.example.composepractice

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.lightColorPalette


val green = Color(0xFF1EB980)
private val themeColors = lightColorPalette(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

@Composable
fun myAppTheme(children: @Composable() ()-> Unit){
    children()
}