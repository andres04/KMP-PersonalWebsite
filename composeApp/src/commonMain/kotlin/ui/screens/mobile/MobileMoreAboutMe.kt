package ui.screens.mobile

import FlipCard
import MobileFlipCard
import SelectableTextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun MobileMoreAboutMe1Screen(height: Dp){

    Box(modifier = Modifier.fillMaxWidth().height(height), contentAlignment = Alignment.Center) {
        Column (modifier = Modifier.fillMaxSize().padding(top = 16.dp, start = 16.dp, end = 16.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                "More About Me",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            MobileFlipCard{
                Column(Modifier.padding(16.dp)) {
                    Text("Education", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("National University of San Marcos", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                    Text("Bachelor Degree in Systems Engineering", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Text("National University of San Marcos", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                    Text("Linux Administration", style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(8.dp))
                    Text("Cambridge English", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                    Text("English - B2 First - FCE", style = MaterialTheme.typography.bodyMedium)

                }
            }
            Spacer(Modifier.height(8.dp))
            MobileFlipCard {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        "Email",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    SelectableTextField("andresescobarvilla@gmail.com")
                }
            }
            Spacer(Modifier.height(8.dp))
            MobileFlipCard {
                Column(Modifier.padding(16.dp)) {
                    Text("Phone", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    SelectableTextField("+51985038537")
                }
            }
            Spacer(Modifier.height(8.dp))
            MobileFlipCard{
                Column(Modifier.padding(16.dp)) {
                    Text("LinkedIn", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.height(8.dp))
                    Text("https://www.linkedin.com/in/andres-escobar-villa", style = MaterialTheme.typography.bodyLarge)
                }
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
fun MobileMoreAboutMe2Screen(height: Dp){
    Box(modifier = Modifier.fillMaxWidth().height(height).padding(bottom = 16.dp, start = 16.dp, end = 16.dp)){
        Column {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ){
                MobileFlipCard{
                    Column(Modifier.padding(16.dp)) {
                        Text("GitHub", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        Text("https://github.com/andres04", style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(Modifier.height(8.dp))
                MobileFlipCard{
                    Column(Modifier.padding(16.dp)) {
                        Text("""
                            |P.S. This webpage was made using Kotlin Multiplatform. That means:
                            |-No HTML
                            |-No CSS
                            |-No Javascript :)
                        """.trimMargin(), style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(Modifier.height(8.dp))

            }
        }
    }
}