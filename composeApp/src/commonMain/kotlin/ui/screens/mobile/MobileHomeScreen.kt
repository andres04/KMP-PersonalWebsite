package ui.screens.mobile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MobileHomeScreen(height: Dp) {
    Box(modifier = Modifier.fillMaxWidth().height(height), contentAlignment = Alignment.Center) {
        Column (modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Column(modifier = Modifier,verticalArrangement = Arrangement.Center) {
                Text(
                    "Hi, I'm Andrés",
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                )
                Spacer(Modifier.height(32.dp))
                Text(
                    "I'm a Mobile Software Architect and\nAndroid/Kotlin Multiplatform Developer.",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.height(8.dp))
                Text("From Lima, Peru", style = MaterialTheme.typography.titleMedium)
            }
            Spacer(Modifier.height(64.dp))
            Image(
                painter = painterResource(DrawableResource("me.jpeg")),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp),
            )
            Spacer(Modifier.height(32.dp))
        }
    }
}

