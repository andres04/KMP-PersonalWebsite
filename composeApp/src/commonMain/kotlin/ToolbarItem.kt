import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ToolbarItem(item: ToolbarItem, selected: ToolbarItem, onSelected: (itemSelected: ToolbarItem)->Unit){
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

sealed class ToolbarItem(val name: String, val position: Int){
    object Home : ToolbarItem(name = "Home", position = 0)
    object Skills : ToolbarItem(name = "Skills", position = 1)
    object WorkExperience : ToolbarItem(name = "Work Experience", position = 2)
    object Education : ToolbarItem(name = "More About Me", position = 3)
}


