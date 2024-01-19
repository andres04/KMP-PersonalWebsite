package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(height: Float) {
    Box(modifier = Modifier.fillMaxWidth().height(height.dp), contentAlignment = Alignment.Center) {
        Row(verticalAlignment = Alignment.CenterVertically){

            Image(
                painter = painterResource(DrawableResource("me.jpeg")),
                contentDescription = null,
                modifier = Modifier
                    .size(720.dp),
            )

            Column(modifier = Modifier,verticalArrangement = Arrangement.Center) {
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
}

