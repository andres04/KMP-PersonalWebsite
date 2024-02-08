package ui.screens.mobile

import AnimatedVerticalGrid
import ToolbarItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.screens.desktop.Skill
import ui.screens.desktop.skills

@Composable
fun MobileSkillsScreen(height: Dp, selected: ToolbarItem, onItemClick: (skill: Skill) -> Unit) {

    var columns by rememberSaveable { mutableStateOf(2) }
    var rows by rememberSaveable { mutableStateOf(5) }
    var items by remember { mutableStateOf(skills) }


    Box(modifier = Modifier.fillMaxWidth().height(height).padding(16.dp), contentAlignment = Alignment.Center) {
        Column {
            Text(
                "My Skills",
                style = MaterialTheme.typography.displayMedium,
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
                    .width(400.dp)
                    .height(600.dp)

            ) {
                MobileSkillItem(
                    Modifier.width(200.dp).height(120.dp).padding(4.dp),
                    skill = it,
                    onItemClick = { skill ->
                        onItemClick(skill)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileSkillItem(modifier: Modifier, skill: Skill, onItemClick: (skill: Skill) -> Unit) {
    Card(
        modifier = modifier,
        onClick = {
            onItemClick(skill)
        }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(skill.title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        }
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            Icon(Icons.Filled.ExpandMore, "FAB Down.")
        }
    }

}

@Composable
fun MobileDetailSkillItem(modifier: Modifier, skill: Skill) {
    Card(modifier = modifier) {
        Column(Modifier.padding(32.dp)) {
            Text(skill.title, style = MaterialTheme.typography.displaySmall, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            skill.subtitles.forEach {
                Text(it, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(16.dp))
            }
        }
    }

}
