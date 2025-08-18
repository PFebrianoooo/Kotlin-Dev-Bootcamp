package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.putrapebrianonurba.kotlindevbootcamp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerBootcamp() {
    // Drawer Badge
    var selectedMenu by remember { mutableStateOf(0) }
    val drawerToggle = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .navigationBarsPadding()
                    .statusBarsPadding()
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight()
                    .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Profile Picture
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color.White)
                        .padding(top = 15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.creator_photo),
                            contentDescription = "Creator Photo",
                            modifier = Modifier
                                .size(130.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.FillBounds
                        )

                        Text(
                            "Putra Pebriano",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(alignment = Alignment.CenterHorizontally)
                        )
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        color = Color.Black,
                        thickness = 1.dp
                    )
                }
                // Menu and Badges
                drawerItem.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = { Text(item.title) },
                        selected = index == selectedMenu,
                        onClick = {
                            selectedMenu = index
                            scope.launch {
                                drawerToggle.close()
                            }
                        },
                        modifier = Modifier.padding(horizontal = 10.dp),
                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                        badge = {
                            if (item.hasBadge) {
                                Badge(containerColor = Color.Transparent) { Text(item.badgeCount.toString(), fontSize = 14.sp) }
                            }
                        },
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color(0xFFF0F0F0),   // abu muda
                            unselectedContainerColor = Color.White,       // putih
                            selectedIconColor = Color.Black,              // hitam
                            unselectedIconColor = Color(0xFF555555),      // abu gelap
                            selectedTextColor = Color.Black,              // hitam
                            unselectedTextColor = Color(0xFF555555)       // abu gelap
                        )

                    )
                }
            }
        },
        drawerState = drawerToggle
    ) {
        // Content of the screen
        when(selectedMenu) {
            0 -> ContentScreenTemplate(scope, drawerToggle, "Profile Screen")
            1 -> ContentScreenTemplate(scope, drawerToggle, "Email Screen")
            2 -> ContentScreenTemplate(scope, drawerToggle, "Favorite Screen")
            3 -> ContentScreenTemplate(scope, drawerToggle, "Settings Screen")
        }
    }
}

@Composable
fun ContentScreenTemplate(scope: CoroutineScope, drawerToggle: DrawerState, screenName: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center)
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                screenName,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Button( onClick = { scope.launch { drawerToggle.open() } }) {
                Text("Open Drawer Menu")
            }
        }
    }
}

private data class DrawerItem(
    val icon: ImageVector,
    val title: String,
    val badgeCount: Int? = null,
    val hasBadge: Boolean
)

private val drawerItem = listOf(
    DrawerItem(Icons.Default.Face, "Profile", 0, false),
    DrawerItem(Icons.Default.Email, "Email", 80, true),
    DrawerItem(Icons.Default.Favorite, "Favorite", 90, true),
    DrawerItem(Icons.Default.Settings, "Settings", 0, false),
)

@Preview(showBackground = true)
@Composable
private fun NavigationDrawerBootcampPreview() {
    NavigationDrawerBootcamp()
}

// Small summary
/*
Navigation Drawer merupakan sebuah menu bar yang terletak di samping kiri layar yang akan hadir apabila ada trigger.
dalam navigatioin drawer terdapat beberapa menu dan sebuah content yang akan ditampilkan.
Konten - konten yang akan di tampilkan meliputi
1. Header/profile image
2. Menu + Badges
 */