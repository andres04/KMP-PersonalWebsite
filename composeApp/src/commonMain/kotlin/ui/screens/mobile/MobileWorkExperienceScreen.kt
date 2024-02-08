package ui.screens.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.screens.desktop.WorkExperience

@Composable
fun MobileWorkExperience1Screen(height: Dp) {
    Box(modifier = Modifier.fillMaxWidth().height(height).padding(start = 16.dp, end = 16.dp, top = 16.dp), contentAlignment = Alignment.TopCenter) {
        Column {
            Text(
                "My Work Experience",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(Modifier.height(16.dp))

            workExperience1List.forEachIndexed { i, it ->


                Row(Modifier.height(IntrinsicSize.Min)){
                    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp).fillMaxHeight().width(32.dp), contentAlignment = Alignment.TopCenter) {
                        Box (
                            contentAlignment= Alignment.Center,
                            modifier = Modifier
                                .size(32.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                ),
                        ){}
                            Box(contentAlignment= Alignment.TopCenter,
                                modifier = Modifier
                                    .padding(
                                        top = when(i){
                                            0 -> 8.dp
                                            else -> 0.dp
                                        },
                                        bottom = 0.dp
                                    )
                                    .fillMaxHeight()
                                    .width(4.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary
                                    ),
                            ){}

                    }
                    Column {
                        MobileWorkExperienceItem(it)
                        Spacer(Modifier.height(16.dp))
                    }

                }
            }
        }

    }
}

@Composable
fun MobileWorkExperience2Screen(height: Dp) {
    Box(modifier = Modifier.fillMaxWidth().height(height).padding(start = 16.dp, end = 16.dp, bottom = 16.dp), contentAlignment = Alignment.TopCenter) {
        Column {
            workExperience2List.forEachIndexed { i, it ->


                Row(Modifier.height(IntrinsicSize.Min)){
                    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp).fillMaxHeight().width(32.dp), contentAlignment = Alignment.TopCenter) {
                        Box (
                            contentAlignment= Alignment.Center,
                            modifier = Modifier
                                .size(32.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                ),
                        ){}
                        if(workExperience2List.size-1 != i){
                            Box(contentAlignment= Alignment.TopCenter,
                                modifier = Modifier
                                    .padding(
                                        top = when(i){
                                            0 -> 8.dp
                                            else -> 0.dp
                                        },
                                        bottom = when(i){
                                            workExperience2List.size-1 -> 8.dp
                                            else -> 0.dp
                                        },
                                    )
                                    .fillMaxHeight()
                                    .width(4.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary
                                    ),
                            ){}
                        } else {
                            Box(contentAlignment= Alignment.TopCenter,
                                modifier = Modifier
                                    .width(4.dp).height(4.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary
                                    ),
                            ){}
                        }
                    }
                    Column {
                        MobileWorkExperienceItem(it)
                        Spacer(Modifier.height(16.dp))
                    }

                }
            }
        }
    }
}

@Composable
fun MobileWorkExperienceItem(
    workExperience: WorkExperience
) {

    Column {
        Text(
            workExperience.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(workExperience.description, style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(4.dp))
        Text(workExperience.date, style = MaterialTheme.typography.bodyLarge)
    }

}

val workExperience1List = listOf(
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
)

val workExperience2List = listOf(
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
        title = "National University of San Marcos",
        description = "Quipucamayoc - Backend Developer",
        date = "2011-2012"
    ),
)