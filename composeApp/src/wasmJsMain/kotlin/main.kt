import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.SkikoGestureEvent
import org.jetbrains.skiko.SkikoView

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
     CanvasBasedWindow(canvasElementId = "ComposeTarget") { App() }
}