package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.ActivityNavigator

@Composable
fun TabRowBootcamp() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    data class tabsIcon (val icon: ImageVector, val title: String)
    val tabs = listOf(
        tabsIcon(Icons.Default.Home, "Post"),
        tabsIcon(Icons.Default.Favorite, "Reels"),
        tabsIcon(Icons.Default.Settings, "Tagging")
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menu Tab
        TabRow(
            selectedTabIndex = selectedTabIndex,

            ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(tab.title, fontWeight = FontWeight.Bold) },
                    // icon = { Icon(tab.icon, contentDescription = tab.title) }
                )
            }
        }

        // Content
        when(selectedTabIndex) {
            0 -> PostImage()
            1 -> ReelsPost()
            2 -> TaggingPost()
        }
    }
}

@Composable
private fun PostImage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Post", fontWeight = FontWeight.ExtraBold, fontSize = 28.sp)
    }
}

@Composable
fun ReelsPost() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Reels", fontWeight = FontWeight.ExtraBold, fontSize = 28.sp)
    }
}

@Composable
fun TaggingPost() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Tagging", fontWeight = FontWeight.ExtraBold, fontSize = 28.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun TabRowBootcampPreview() {
    TabRowBootcamp()
}

// Small Summary
/*
Tab Row
merupakan sebuah menu tab navigasi pada yang dipakai untuk membuat menu sejajar, Tab Row dapat kita jumpai di instagram
Di instagram ada Konten Post, Reels dan tagging. Itu merupakan contoh kongkrit dari tab row
 */