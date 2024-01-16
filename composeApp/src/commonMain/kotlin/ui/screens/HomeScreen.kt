package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(height: Float) {
    Box(modifier = Modifier.fillMaxWidth().height(height.dp), contentAlignment = Alignment.Center) {
        Column {
            Text(
                "Hi, I'm Andrés",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(32.dp))
            Text(
                "I'm a Mobile Software Architect and\nAndroid/Kotlin Multiplatform Developer.",
                style = MaterialTheme.typography.displayMedium
            )
            Text("From Lima, Peru", style = MaterialTheme.typography.displaySmall)
        }
    }
}

