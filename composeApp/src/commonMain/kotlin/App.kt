import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ui.screens.desktop.HomeScreen
import ui.screens.desktop.MoreAboutMeScreen
import ui.screens.desktop.SkillsScreen
import ui.screens.desktop.WorkExperienceScreen
import ui.screens.desktop.skills
import ui.screens.mobile.MobileDetailSkillItem
import ui.screens.mobile.MobileDummyScreen
import ui.screens.mobile.MobileHomeScreen
import ui.screens.mobile.MobileMoreAboutMe1Screen
import ui.screens.mobile.MobileMoreAboutMe2Screen
import ui.screens.mobile.MobileSkillsScreen
import ui.screens.mobile.MobileWorkExperience1Screen
import ui.screens.mobile.MobileWorkExperience2Screen
import ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun App() {
    var selected by remember { mutableStateOf<ToolbarItem>(ToolbarItem.Home) }
    val darkColor = true//isSystemInDarkTheme() no funciona aún en wasm
    var isDarkColor by remember { mutableStateOf(darkColor) }
    val density = LocalDensity.current
    val height = LocalWindowInfo.current.containerSize.height*density.density
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val windowSizeClass = calculateWindowSizeClass()
    val isMobile = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    var openAlertDialog by remember { mutableStateOf(false) }
    var selectedSkill by remember { mutableStateOf(skills[0]) }
    var itemsSize = if(isMobile) 6 else 4

    // Create element height in dp state
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    selected =
        if(!isMobile){
            when(listState.firstVisibleItemIndex){
                0 -> ToolbarItem.Home
                1 -> ToolbarItem.Skills
                2 -> ToolbarItem.WorkExperience
                else -> ToolbarItem.Education
            }
        } else {
            when(listState.firstVisibleItemIndex){
                0 -> ToolbarItem.Home
                1 -> ToolbarItem.Skills
                2 -> ToolbarItem.WorkExperience
                3 -> ToolbarItem.WorkExperience
                4 -> ToolbarItem.Education
                else -> ToolbarItem.Education
            }
        }



    AppTheme(
        darkTheme = isDarkColor,
        type = if(isMobile) selected.mobilePosition else selected.webPosition
    ) {
        Scaffold{paddingValues ->

            val bgColor: Color by animateColorAsState(
                MaterialTheme.colorScheme.background
                ,animationSpec = tween(1000, easing = LinearEasing)
            )

            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(16.dp)
                        ){
                            Text("My Webpage", modifier = Modifier.padding(16.dp))
                        }
                        Divider(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
                        NavigationDrawerItem(
                            label = { Text(text = "Home") },
                            selected = false,
                            onClick = {
                                moveToScreenFromNavigator(
                                    coroutineScope = coroutineScope,
                                    drawerState = drawerState,
                                    listState = listState,
                                    index = 0
                                )
                            },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "Skills") },
                            selected = false,
                            onClick = {
                                moveToScreenFromNavigator(
                                    coroutineScope = coroutineScope,
                                    drawerState = drawerState,
                                    listState = listState,
                                    index = 1
                                )
                            },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "Work Experience") },
                            selected = false,
                            onClick = {
                                moveToScreenFromNavigator(
                                    coroutineScope = coroutineScope,
                                    drawerState = drawerState,
                                    listState = listState,
                                    index = 2
                                )
                            },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                        NavigationDrawerItem(
                            label = { Text(text = "More About Me") },
                            selected = false,
                            onClick = {
                                if(isMobile){
                                    moveToScreenFromNavigator(
                                        coroutineScope = coroutineScope,
                                        drawerState = drawerState,
                                        listState = listState,
                                        index = 4
                                    )
                                    coroutineScope.launch {
                                        delay(500)
                                        listState.animateScrollToItem(listState.firstVisibleItemIndex+1)
                                    }
                                } else {
                                    moveToScreenFromNavigator(
                                        coroutineScope = coroutineScope,
                                        drawerState = drawerState,
                                        listState = listState,
                                        index = 3
                                    )
                                }

                            },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                        )
                    }
                }
            ) {
                // Screen content
                Column(modifier = Modifier.padding(paddingValues)){
                    Toolbar(
                        selected = selected,
                        onSelected = {
                            coroutineScope.launch {
                                listState.animateScrollToItem(if(isMobile)it.mobilePosition else it.webPosition)
                            }
                        },
                        isDarkColor = isDarkColor,
                        onDarkColorClick = {
                            isDarkColor = it
                        },
                        onNavigationIconSelected = {
                            coroutineScope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }
                    )

                    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().onGloballyPositioned { coordinates ->
                        // Set column height using the LayoutCoordinates
                        columnHeightDp = with(density) { coordinates.size.height.toDp() }
                    }){
                        LazyColumn(
                            modifier = Modifier.background(bgColor),
                            state = listState,
                        ){
                            item {
                                if(isMobile) {
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileHomeScreen(columnHeightDp)
                                } else {
                                    HomeScreen(height)
                                }
                            }
                            item {
                                if(isMobile) {
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileSkillsScreen(
                                        height = columnHeightDp,
                                        selected = selected,
                                        onItemClick = { skill ->
                                            selectedSkill = skill
                                            openAlertDialog = true
                                        }
                                    )
                                } else {
                                    SkillsScreen(height, selected)
                                }

                            }
                            item {
                                if(isMobile) {
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileWorkExperience1Screen(columnHeightDp)
                                } else {
                                    WorkExperienceScreen()
                                }
                            }
                            if(isMobile) {
                                item {
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileWorkExperience2Screen(columnHeightDp)
                                }
                            }
                            item {
                                if(isMobile){
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileMoreAboutMe1Screen(columnHeightDp)
                                } else {
                                    MoreAboutMeScreen(height)
                                }
                            }
                            if(isMobile) {
                                item {
                                    //MobileDummyScreen(columnHeightDp)
                                    MobileMoreAboutMe2Screen(columnHeightDp)
                                }
                            }
                        }
                        Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
                            //Text("position: " + listState.firstVisibleItemIndex+" itemsSize:"+itemsSize+" height:"+columnHeightDp)
                            if(listState.firstVisibleItemIndex != 0){
                                FloatingActionButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(listState.firstVisibleItemIndex-1)
                                        }
                                    },
                                ) {
                                    Icon(Icons.Filled.ArrowUpward, "FAB Up.")
                                }
                            }
                            Spacer(Modifier.height(8.dp))
                            if(listState.firstVisibleItemIndex != itemsSize-1){
                                FloatingActionButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(listState.firstVisibleItemIndex+1)
                                        }
                                    },
                                ) {
                                    Icon(Icons.Filled.ArrowDownward, "FAB Down.")
                                }
                            }
                        }
                    }
                }
            }

            if(openAlertDialog){
                Dialog(
                    onDismissRequest = {
                        openAlertDialog = false
                    },
                ){
                    MobileDetailSkillItem(modifier = Modifier, skill = selectedSkill)
                }
            }
        }
    }
}

private fun moveToScreenFromNavigator(
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    listState: LazyListState,
    index: Int
) {
    coroutineScope.launch {
        drawerState.apply {
            if (isClosed) open() else close()
        }
        listState.animateScrollToItem(index)
    }
}



