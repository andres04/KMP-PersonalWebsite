package pe.hexagonsys.andres

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(kotlinx.browser.window.innerWidth, kotlinx.browser.window.innerHeight)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(kotlinx.browser.window.innerWidth, kotlinx.browser.window.innerHeight)
}