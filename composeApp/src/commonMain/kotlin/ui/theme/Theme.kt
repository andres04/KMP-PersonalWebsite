package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.materialkolor.dynamicColorScheme

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    type: Int = 0,
    content: @Composable() () -> Unit
) {

    val colorScheme = dynamicColorScheme(
        when(type){
            0 -> Color(0xFF39608F)
            1 -> Color(0xFFCDEDA3)
            2 -> Color(0xFF8F4C38)
            3 -> Color(0xFF6D5E0F)
            else -> Color(0xFF6D5E0F)
        },
        darkTheme
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}

