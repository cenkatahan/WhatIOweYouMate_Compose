package com.ata.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class OweColor(
    val lightColor: Color,
    val darkColor: Color
) {
    @Composable
    fun color(
        alpha: Float = 1f
    ): Color {
        return when (isSystemInDarkTheme()) {
            false -> lightColor.copy(alpha = alpha)
            true -> darkColor.copy(alpha = alpha)
        }
    }
}