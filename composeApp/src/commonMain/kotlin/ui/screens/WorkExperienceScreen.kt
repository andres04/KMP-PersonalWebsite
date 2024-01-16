package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WorkExperienceScreen() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Column(Modifier.width(1500.dp)) {
            Spacer(Modifier.height(64.dp))
            Text(
                "My Work Experience",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(32.dp))

            workExperienceList.forEach {
                WorkExperienceItem(it)
            }
        }

    }
}

@Composable
fun WorkExperienceItem(
    workExperience: WorkExperience
) {
    Row {
        Column {
            Text(
                workExperience.title,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))
            Text(workExperience.description, style = MaterialTheme.typography.headlineSmall)
            Text(workExperience.date, style = MaterialTheme.typography.headlineSmall)
        }
    }
    Spacer(Modifier.height(64.dp))
}

data class WorkExperience(
    val id: Int,
    val title: String,
    val description: String,
    val date: String
)

val workExperienceList = listOf(
    WorkExperience(
        id = 0,
        title = "Hexagonsys",
        description = "Linux Server Management",
        date = "2023"
    ),
    WorkExperience(
        id = 1,
        title = "AMC",
        description = "AMC+ App - Android Architect",
        date = "2022"
    ),
    WorkExperience(
        id = 0,
        title = "Claro",
        description = "ClaroClub App - Android Architect & Team leader",
        date = "2021"
    ),
    WorkExperience(
        id = 0,
        title = "BCP",
        description = "BCP Mobile Banking App - Senior Android Developer",
        date = "2020"
    ),
    WorkExperience(
        id = 0,
        title = "EV Project Services",
        description = "GPS Tracker App - Senior Android Developer",
        date = "2019"
    ),
    WorkExperience(
        id = 0,
        title = "Belcorp",
        description = "Esika & L'bel Conmigo - Senior Android Developer",
        date = "2017-2018"
    ),
    WorkExperience(
        id = 0,
        title = "Solera Mobile",
        description = "Many apps - Senior Android Developer",
        date = "2015-2016"
    ),
    WorkExperience(
        id = 0,
        title = "Avantica",
        description = "Entel Retail Sales App - Android Developer",
        date = "2014"
    ),
    WorkExperience(
        id = 0,
        title = "Mediabyte",
        description = "BBVA Mundo Sueldo - Backend & Android Developer",
        date = "2013"
    ),
    WorkExperience(
        id = 0,
        title = "San Marcos University",
        description = "Quipucamayoc - Backend Developer",
        date = "2011-2012"
    ),
)