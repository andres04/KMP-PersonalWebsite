package ui.screens

import FlipCard
import SelectableTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MoreAboutMe(height: Float){
    Box(modifier = Modifier.fillMaxWidth().height(height.dp), contentAlignment = Alignment.Center){
        Column {
            Text(
                "More About Me",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(32.dp))
            LazyVerticalGrid(
                modifier = Modifier.width(1500.dp),
                columns = GridCells.Adaptive(minSize = 500.dp)
            ){
                item(
                    span = {
                        GridItemSpan(2)
                    }
                ){
                    FlipCard(width =1000.dp, height =496.dp){
                        Column(Modifier.padding(32.dp)) {
                            Text("Education", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(16.dp))
                            Text("National University of San Marcos", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text("Bachelor Degree in Systems Engineering", style = MaterialTheme.typography.headlineSmall)
                            Spacer(Modifier.height(16.dp))
                            Text("National University of San Marcos", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text("Linux Administration", style = MaterialTheme.typography.headlineSmall)
                            Spacer(Modifier.height(16.dp))
                            Text("Cambridge English", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                            Text("English - B2 First - FCE", style = MaterialTheme.typography.headlineSmall)
                        }
                    }
                }
                item{
                    Column {
                        FlipCard(width =540.dp, height =240.dp){
                            Column(Modifier.padding(32.dp)) {
                                Text("Email", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                                Spacer(Modifier.height(16.dp))
                                SelectableTextField("andresescobarvilla@gmail.com")
                            }

                        }
                        FlipCard(width =540.dp, height =240.dp){
                            Column(Modifier.padding(32.dp)) {
                                Text("Phone", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                                Spacer(Modifier.height(16.dp))
                                Text("+51 985 038 537", style = MaterialTheme.typography.headlineSmall)
                            }
                        }
                    }
                }
                item{
                    FlipCard(width =540.dp, height =240.dp){
                        Column(Modifier.padding(32.dp)) {
                            Text("LinkedIn", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(16.dp))
                            Text("+51 985 038 537", style = MaterialTheme.typography.headlineSmall)
                        }
                    }
                }
                item{
                    FlipCard(width =540.dp, height =240.dp){
                        Column(Modifier.padding(32.dp)) {
                            Text("GitHub", style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(16.dp))
                            Text("+51 985 038 537", style = MaterialTheme.typography.headlineSmall)
                        }
                    }
                }
                item{
                    FlipCard(width =540.dp, height =240.dp){
                        Column(Modifier.padding(32.dp)) {
                            Text("""
                                |P.S. This webpage was made using Kotlin Multiplatform. That means:
                                |-No HTML
                                |-No CSS
                                |-No Javascript :)
                            """.trimMargin(), style = MaterialTheme.typography.headlineSmall)
                        }

                    }
                }
            }
        }
    }
}