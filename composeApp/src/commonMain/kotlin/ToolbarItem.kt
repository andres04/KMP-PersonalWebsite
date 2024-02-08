import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ToolbarItem(item: ToolbarItem, selected: ToolbarItem, onSelected: (itemSelected: ToolbarItem)->Unit){

    val windowSizeClass = calculateWindowSizeClass()
    if(windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact){
        if(item == selected){
            Button(
                onClick = { onSelected(item) },
                content = {
                    Text(item.name)
                }
            )
        } else{
            OutlinedButton(
                onClick = { onSelected(item) },
                content = {
                    Text(item.name)
                }
            )
        }
    }



}

sealed class ToolbarItem(val name: String, val webPosition: Int, val mobilePosition: Int){
    object Home : ToolbarItem(name = "Home", webPosition = 0, mobilePosition = 0)
    object Skills : ToolbarItem(name = "Skills", webPosition = 1, mobilePosition = 1)
    object WorkExperience : ToolbarItem(name = "Work Experience", webPosition = 2, mobilePosition = 2)
    object Education : ToolbarItem(name = "More About Me", webPosition = 3, mobilePosition = 4)
}


