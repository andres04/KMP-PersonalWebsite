import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isTertiary
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    var selected by remember { mutableStateOf<ToolbarItem>(ToolbarItem.Home) }
    val darkColor = true//isSystemInDarkTheme() no funciona aún en wasm
    println(darkColor)
    var isDarkColor by remember { mutableStateOf(darkColor) }
    val density = LocalDensity.current
    val h = LocalWindowInfo.current.containerSize.height*density.density
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    println(h.toString()+" "+listState.firstVisibleItemIndex)
    selected = when(listState.firstVisibleItemIndex){
        0 -> ToolbarItem.Home
        1 -> ToolbarItem.Skills
        2 -> ToolbarItem.WorkExperience
        else -> ToolbarItem.Education
    }

    AppTheme(
        darkTheme = isDarkColor,
        type = selected.position
    ) {
        Scaffold{paddingValues ->

            val bgColor: Color by animateColorAsState(
                MaterialTheme.colorScheme.background
                ,animationSpec = tween(500, easing = LinearEasing)
            )

            Column(modifier = Modifier.padding(paddingValues)){
                Toolbar(
                    selected = selected,
                    onSelected = {
                        coroutineScope.launch {
                            listState.animateScrollToItem(it.position)
                        }
                    },
                    isDarkColor = isDarkColor,
                    onDarkColorClick = {
                        isDarkColor = it
                    }
                )



                LazyColumn(modifier = Modifier.background(bgColor), state = listState){
                    item {
                        Box(modifier = Modifier.fillMaxWidth().height(h.dp), contentAlignment = Alignment.Center){
                            Column {
                                Text(
                                    "Hi, I'm Andrés",
                                    style = MaterialTheme.typography.displayLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                )
                                Text("I'm a Mobile Software Architect and\nAndroid/Kotlin Multiplatform Developer.", style = MaterialTheme.typography.displayMedium)
                                Text("From Lima, Peru", style = MaterialTheme.typography.displaySmall)
                                Text("From Lima, Peru", style = MaterialTheme.typography.displaySmall)
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier.fillMaxWidth().height(h.dp), contentAlignment = Alignment.Center){
                            Column {
                                Text(
                                    "My Skills",
                                    style = MaterialTheme.typography.displayLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary,
                                )
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(3)
                                ){
                                    item {
                                        SkillItem()
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                    item {
                                        Card(modifier = Modifier.padding(16.dp)) {
                                            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier.fillMaxWidth().height(h.dp)){

                        }
                    }
                    item {
                        Box(modifier = Modifier.fillMaxWidth().height(h.dp)){

                        }
                    }
                }
            }

        }
    }
}

@Composable
private fun SkillItem() {
    Card(modifier = Modifier.padding(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Kotlin Multiplatform", style = MaterialTheme.typography.displaySmall)
        }

    }
}

