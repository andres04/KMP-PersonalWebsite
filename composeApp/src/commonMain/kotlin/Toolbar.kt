import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Toolbar(
    selected: ToolbarItem,
    onSelected: (itemSelected: ToolbarItem) -> Unit,
    isDarkColor: Boolean,
    onDarkColorClick: (isDarkColor: Boolean) ->Unit,
    onNavigationIconSelected: () -> Unit,
) {

    val windowSizeClass = calculateWindowSizeClass()

    val bgColor: Color by animateColorAsState(MaterialTheme.colorScheme.surface, animationSpec = tween(500, easing = LinearEasing))

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = bgColor),
        title = {
            Row {
                ToolbarItem(
                    item = ToolbarItem.Home,
                    selected = selected,
                    onSelected = {onSelected(it)}
                )
                Spacer(Modifier.width(4.dp))
                ToolbarItem(
                    item = ToolbarItem.Skills,
                    selected = selected,
                    onSelected = {onSelected(it)}
                )
                Spacer(Modifier.width(4.dp))
                ToolbarItem(
                    item = ToolbarItem.WorkExperience,
                    selected = selected,
                    onSelected = {onSelected(it)}
                )
                Spacer(Modifier.width(4.dp))
                ToolbarItem(
                    item = ToolbarItem.Education,
                    selected = selected,
                    onSelected = {onSelected(it)}
                )
            }
        },
        navigationIcon =
            if(windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact){
                {
                    IconButton(onClick = { onNavigationIconSelected() }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
            } else {
                {}
            }
        ,
        actions = {
            IconButton(onClick = { onDarkColorClick(!isDarkColor) }) {
                Icon(imageVector = Icons.Filled.DarkMode, contentDescription = null)
            }
        }
    )
}