package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    type: Int = 0,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      darkTheme && type == 0 -> Color0.darkScheme
      darkTheme && type == 1 -> Color1.darkScheme
      darkTheme && type == 2 -> Color2.darkScheme
      darkTheme && type == 3 -> Color3.darkScheme
      !darkTheme && type == 0 -> Color0.lightScheme
      !darkTheme  && type == 1 -> Color1.lightScheme
      !darkTheme  && type == 2 -> Color2.lightScheme
      !darkTheme  && type == 3 -> Color3.lightScheme
      else -> Color0.lightScheme
  }
  MaterialTheme(
    colorScheme = colorScheme,
    typography = androidx.compose.material3.Typography(),
    content = content
  )
}

