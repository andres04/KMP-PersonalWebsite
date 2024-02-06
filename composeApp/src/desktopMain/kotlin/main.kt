import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Andres") {
        App(kotlinx.browser.window.innerWidth, kotlinx.browser.window.innerHeight)
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App(kotlinx.browser.window.innerWidth, kotlinx.browser.window.innerHeight)
}