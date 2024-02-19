package ui.screens.mobile

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
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
            ProfileText()
            Spacer(Modifier.height(64.dp))
            ProfileImage()
            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
@OptIn(ExperimentalResourceApi::class)
private fun ProfileImage() {
    var visible by remember { mutableStateOf(false) }

    val animationTime = (300..900).random()
    val animationDelayTime = 5

    val arrowStartLocation = Offset(-200F, 0F)
    val arrowEndLocation = Offset(0F, 0F)

    LaunchedEffect(Unit) {
        visible = true
    }
    val arrowLocation by animateOffsetAsState(
        targetValue = if (visible) arrowEndLocation else arrowStartLocation,
        animationSpec = tween(animationTime, animationDelayTime, easing = LinearOutSlowInEasing)
    )

    Image(
        painter = painterResource(DrawableResource("me.jpeg")),
        contentDescription = null,
        modifier = Modifier
            .size(400.dp).offset(arrowLocation.x.dp, arrowLocation.y.dp),
    )
}

@Composable
private fun ProfileText() {
    var visible by remember { mutableStateOf(false) }

    val animationTime = (300..900).random()
    val animationDelayTime = 5

    val arrowStartLocation = Offset(200F, 0F)
    val arrowEndLocation = Offset(0F, 0F)

    LaunchedEffect(Unit) {
        visible = true
    }
    val arrowLocation by animateOffsetAsState(
        targetValue = if (visible) arrowEndLocation else arrowStartLocation,
        animationSpec = tween(animationTime, animationDelayTime, easing = LinearOutSlowInEasing)
    )

    Column(modifier = Modifier.offset(arrowLocation.x.dp, arrowLocation.y.dp), verticalArrangement = Arrangement.Center) {
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
}



