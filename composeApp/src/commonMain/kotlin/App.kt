import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ui.screens.HomeScreen
import ui.screens.SkillItem
import ui.screens.SkillsScreen
import ui.screens.WorkExperienceScreen
import ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    var selected by remember { mutableStateOf<ToolbarItem>(ToolbarItem.Home) }
    val darkColor = true//isSystemInDarkTheme() no funciona aún en wasm
    println(darkColor)
    var isDarkColor by remember { mutableStateOf(darkColor) }
    val density = LocalDensity.current
    val height = LocalWindowInfo.current.containerSize.height*density.density
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    println(height.toString()+" "+listState.firstVisibleItemIndex)
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
                ,animationSpec = tween(1000, easing = LinearEasing)
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
                        HomeScreen(height)
                    }
                    item {
                        SkillsScreen(height, selected)
                    }
                    item {
                        WorkExperienceScreen()
                    }
                    item {
                        Box(modifier = Modifier.fillMaxWidth().height(height.dp)){

                        }
                    }
                }
            }

        }
    }
}



