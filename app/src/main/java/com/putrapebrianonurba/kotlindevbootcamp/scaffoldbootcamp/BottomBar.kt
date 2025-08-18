package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


private data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeCount: Int
)

private val navItems = listOf(
    NavItemState(
        title = "Jadwal Shalat",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        hasBadge = true,
        badgeCount = 0
    ),
    NavItemState(
        title = "Al-Quran",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Outlined.Email,
        hasBadge = true,
        badgeCount = 10
    ),
    NavItemState(
        title = "Doa Pilihan",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        hasBadge = true,
        badgeCount = 10
    )
)

@Composable
fun BottomBarBootcamp() {
    var bottomBarState by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                navItems.forEachIndexed{ index, icon ->
                    NavigationBarItem(
                        selected = bottomBarState == index,
                        onClick = { bottomBarState = index },
                        icon = {
                            BadgedBox(badge = {
                                if (icon.hasBadge && icon.badgeCount > 0) {
                                    Badge {
                                        Text(text = icon.badgeCount.toString())
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = if (bottomBarState == index) icon.selectedIcon else icon.unselectedIcon,
                                    contentDescription = icon.title,
                                    modifier = Modifier.size(26.dp),
                                )
                            }
                        },
                        label = {
                            Text(text = icon.title, style = if (bottomBarState == index) LocalTextStyle.current.merge(TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold)) else LocalTextStyle.current.merge(TextStyle(fontSize = 15.sp)))
                        },
                        colors = NavigationBarItemDefaults.colors(
                            // selectedIconColor = Color.Black,
                            // selectedTextColor = Color.Black,
                            indicatorColor = Color.LightGray.copy(alpha = 0.3f),
                            // unselectedIconColor = Color.LightGray,
                            // unselectedTextColor = Color.LightGray
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = navItems[bottomBarState].title,
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarBootcampPreview() {
    BottomBarBootcamp()
}

// Small Summary
/*
> Navigation Bar Item lambda
selected: Boolean,
onClick: () -> Unit,
icon: @Composable () -> Unit,
modifier: Modifier = Modifier,
enabled: Boolean = true,
label: @Composable (() -> Unit)? = null,
alwaysShowLabel: Boolean = true,
colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
interactionSource: MutableInteractionSource? = null
*/