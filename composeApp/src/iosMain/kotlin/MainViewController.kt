import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController { App(
    kotlinx.browser.window.innerWidth,
    kotlinx.browser.window.innerHeight
)
}
