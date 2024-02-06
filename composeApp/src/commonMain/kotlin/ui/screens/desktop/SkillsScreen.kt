package ui.screens.desktop

import AnimatedVerticalGrid
import ToolbarItem
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SkillsScreen(height: Float, selected: ToolbarItem) {

    var columns by rememberSaveable { mutableStateOf(3) }
    var rows by rememberSaveable { mutableStateOf(3) }
    var items by remember { mutableStateOf(skills) }


    Box(modifier = Modifier.fillMaxWidth().height(height.dp), contentAlignment = Alignment.Center) {
        Column {
            Text(
                "My Skills",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(32.dp))
            AnimatedVerticalGrid(
                items = if (selected == ToolbarItem.Skills) items.sortedBy { it.id } else items.shuffled(),
                itemKey = Skill::id,
                columns = columns,
                rows = rows,
                modifier = Modifier
                    .width(1500.dp)
                    .height(850.dp)

            ) {
                SkillItem(
                    Modifier.width(500.dp).padding(16.dp),
                    skill = it
                )
            }
        }
    }
}

@Composable
fun SkillItem(modifier: Modifier, skill: Skill) {
    Card(modifier = modifier) {
        Column(Modifier.padding(32.dp)) {
            Text(skill.title, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            skill.subtitles.forEach {
                Text(it, style = MaterialTheme.typography.headlineSmall)
            }
        }
    }

}

data class Skill(
    val id: Int,
    val title: String,
    val subtitles: List<String>
)

val skills = listOf(
    Skill(
        id = 0,
        title = "Kotlin Multiplatform",
        subtitles = listOf(
            "Compose Multiplatform/Material 3",
            "Android/iOS/Desktop/Wasm",
            "Koin",
            "SQLDelight",
        )
    ),
    Skill(
        id = 1,
        title = "Android",
        subtitles = listOf(
            "Jetpack Compose/MVVM",
            "Clean Architecture",
            "Android Jetpack Libraries",
            "Firebase/Google APIs"
        )
    ),
    Skill(
        id = 2,
        title = "Kotlin",
        subtitles = listOf(
            "Ktor",
            "Coroutines",
            "Kotlin Flow",
            "Kotlinx Serialization"
        )
    ),
    Skill(
        id = 3,
        title = "Java Backend",
        subtitles = listOf(
            "Spring Boot",
            "Spring MVC",
            "Spring Data/JPA",
            "Spring Security"
        )
    ),
    Skill(
        id = 4,
        title = "Testing",
        subtitles = listOf(
            "JUnit",
            "MockK",
            "Compose UI Testing",
            "TDD"
        )
    ),
    Skill(
        id = 5,
        title = "Linux Sysadmin",
        subtitles = listOf(
            "Ubuntu Server",
            "Nginx/Postgres/PHP",
            "Qemu/Docker",
            "UFW/Bind9/Netplan",
        )
    ),
    Skill(
        id = 6,
        title = "CI/CD",
        subtitles = listOf(
            "Gradle",
            "Jenkins",
            "Git/Gitflow",
            "Google Play Store"
        )
    ),
    Skill(
        id = 7,
        title = "Agile Tools & Techniques",
        subtitles = listOf(
            "Scrum",
            "Jira",
            "Confluence",
            "Github"
        )
    ),
    Skill(
        id = 8,
        title = "Soft Skills",
        subtitles = listOf(
            "Self-learning",
            "People and interpersonal skills",
            "Problem-solving skills",
            "Critical thinking"
        )
    )
)

