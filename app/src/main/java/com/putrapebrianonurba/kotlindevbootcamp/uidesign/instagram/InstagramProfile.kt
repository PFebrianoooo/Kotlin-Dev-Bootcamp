package com.putrapebrianonurba.kotlindevbootcamp.uidesign.instagram

import com.putrapebrianonurba.kotlindevbootcamp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.VideoLibrary
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InstagramLayouts() {
    // State Variables
    var selectedMenu by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(selectedMenu){ selectedMenu = it } }
    ) { innerPadding ->
        when (selectedMenu) {
            0 -> AnotherContent("Home Content", modifier = Modifier.padding(innerPadding))
            1 -> AnotherContent("Search Content", modifier = Modifier.padding(innerPadding))
            2 -> AnotherContent("Adding Posts Content", modifier = Modifier.padding(innerPadding))
            3 -> AnotherContent("Reels Content", modifier = Modifier.padding(innerPadding))
            4 -> ProfileInfo(modifier = Modifier.padding(innerPadding))
        }
    }
}

// TOP & BOTTOM BAR COMPOSABLE UNIT
@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Column {
        Box (
            modifier
                .background(Color.White)
                .fillMaxWidth()
                .statusBarsPadding()
                .height(45.dp),
            contentAlignment = Alignment.Center
        ) {
            // Profile Information
            Row(
                modifier.clickable(onClick = { /*TODO*/ }),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Filled.Lock,
                    contentDescription = null,
                    modifier.size(12.dp),
                    tint = Color.Black

                )

                Text(
                    text = "p.febrianoo_",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black

                )

                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier.size(15.dp),
                    tint = Color.Black
                )
            }

            // Hamburger Menu
            Icon(
                Icons.Filled.Menu,
                contentDescription = null,
                modifier
                    .padding(end = 15.dp)
                    .clickable(onClick = { /*TODO*/ })
                    .align(alignment = Alignment.CenterEnd)
                    .size(24.dp),
                tint = Color.Black
            )
        }

        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
    }
}

private data class BottomNavIcon(
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val iconName: String
)

private val iconButton = listOf(
    BottomNavIcon(Icons.Filled.Home, Icons.Outlined.Home, "Home"),
    BottomNavIcon(Icons.Filled.Search, Icons.Outlined.Search, "Search"),
    BottomNavIcon(Icons.Filled.AddBox, Icons.Outlined.AddBox, "AddPost"),
    BottomNavIcon(Icons.Filled.VideoLibrary, Icons.Outlined.VideoLibrary, "Reels"),
    BottomNavIcon(Icons.Filled.Person, Icons.Outlined.Person, "Profile")
)

@Composable
private fun BottomBar(selectedMenu: Int,modifier: Modifier = Modifier, onIconSelected: (Int) -> Unit) {
    Row(
        modifier
            .background(Color.White)
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .navigationBarsPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // menu Icons
        iconButton.forEachIndexed { index, icons ->
            val selectedIcon = selectedMenu == index

            Box(
                modifier
                    .clickable(onClick = { onIconSelected(index) })
                    .size(55.dp, 30.dp),
                contentAlignment = Alignment.Center,
            ) {
                if (selectedIcon) {
                    Icon(
                        icons.iconSelected,
                        contentDescription = icons.iconName,
                        modifier.fillMaxSize(0.9f),
                        tint = Color.Black
                    )
                } else {
                    Icon(
                        icons.iconUnselected,
                        contentDescription = icons.iconName,
                        modifier.fillMaxSize(0.9f),
                        tint = Color.Black)
                }
            }
        }
    }
}

@Composable
private fun ProfileInfo(modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableIntStateOf(0) }

    LazyColumn (
        modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            ProfileInfoSection()
            ProfileBioDescription()
            ActionButtonSection()
            HighlightsSection()
            TabSection(selectedTab = selectedTab, onTabSelected = { selectedTab = it })
        }

        when(selectedTab) {
            0 -> item{ GridSectionV1(1..100) }
            1 -> item{ GridSectionV1(1..5) }
            2 -> item{ GridSectionV1(1..3) }
        }
    }
}

@Composable
private fun ProfileInfoSection(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image
        Image(
            painterResource(R.drawable.creator_photo),
            contentDescription = "Creator-Photo",
            modifier
                .size(80.dp)
                .border(1.dp, Color.Gray, CircleShape)
                .padding(3.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier.width(15.dp))

        // Post, Followers & Following
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "0",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Text(
                    text = "Posts",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black,
                    letterSpacing = 0.5.sp
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "2168",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Text(
                    text = "Followers",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black,
                    letterSpacing = 0.5.sp
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "1183",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Text(
                    text = "Following",
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black,
                    letterSpacing = 0.5.sp
                )
            }
        }

    }

}

@Composable
private fun ProfileBioDescription(modifier: Modifier = Modifier) {
    val bioText = buildAnnotatedString {
        // Nama
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.Black)) {
            append("Putra Pebriano Nurba\n")
        }

        // Profesi / bio
        withStyle(style = SpanStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp, color = Color.Black)) {
            append("Mobile Software Developer @tokopedia\n")
            append("Mobile Dev Native iOS & Android | Software Enthusiast\n")
        }

        // Link github
        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = Color.Blue)) {
            append("www.github.com/PFebrianoooo")
        }
    }

    Text(
        text = bioText,
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 5.dp),
        lineHeight = 18.sp
    )
}

@Composable
private fun ActionButtonSection(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier
                .clickable(onClick = { /*TODO*/ })
                .weight(1f)
                .height(32.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(15)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Edit Profile",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.Black,
            )
        }

        Spacer(modifier.width(10.dp))

        Box(
            modifier
                .clickable(onClick = { /*TODO*/ })
                .weight(1f)
                .height(32.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(15)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Share Profile",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
    }
}

@Composable
private fun HighlightsSection(modifier: Modifier = Modifier) {
    LazyRow(
        modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(10) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painterResource(R.drawable.creator_photo),
                    contentDescription = "Creator-Photo",
                    modifier
                        .size(65.dp)
                        .border(1.dp, Color.Gray, CircleShape)
                        .padding(3.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier.height(5.dp))

                Text(
                    // In title input, must be filtered to 1 - 15 letters
                    "Highlights",
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
private fun TabSection(modifier: Modifier = Modifier, selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf(
        Icons.Default.GridOn,
        Icons.Default.VideoLibrary,
        Icons.Default.Person
    )
    Column {
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTab]),
                    color = Color.Black,
                    height = 2.dp
                )
            },
            divider = { }
        ) {
            tabs.forEachIndexed { index, iconRes ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { onTabSelected(index) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                ) {
                    Icon(
                        imageVector = iconRes,
                        contentDescription = "Tab $index",
                        modifier
                            .padding(10.dp)
                            .size(24.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun GridSectionV1(rangeItem: IntRange) {
    // manual grid 3 kolom
    val items = rangeItem.toList() // simulasi jumlah post
    val chunked = items.chunked(3) // pecah jadi baris 3 item

    Column {
        chunked.forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                rowItems.forEach { _ ->
                    Image(
                        painter = painterResource(R.drawable.creator_photo),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f), // biar kotak
                        contentScale = ContentScale.Crop
                    )
                }

                // Kalau kurang dari 3 item, kasih Spacer biar rata
                repeat(3 - rowItems.size) {
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Composable
fun GridSectionV2(modifier: Modifier = Modifier, images: List<Int>) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // hitung jumlah row dari total item
        val rowCount = (images.size + 2) / 3

        items(rowCount) { rowIndex ->
            Row(modifier = Modifier.fillMaxWidth()) {
                for (colIndex in 0 until 3) {
                    val itemIndex = rowIndex * 3 + colIndex
                    if (itemIndex < images.size) {
                        Image(
                            painter = painterResource(images[itemIndex]),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GridSectionV3(totalPosts: Int, columns: Int, imageRes: Int) {
    val rowCount = (totalPosts + columns - 1) / columns

    LazyColumn {
        items(rowCount) { rowIndex ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                for (colIndex in 0 until columns) {
                    val itemIndex = rowIndex * columns + colIndex
                    if (itemIndex < totalPosts) {
                        Image(
                            painter = painterResource(imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AnotherContent(content: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center) {
        Text(content, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_8")
@Composable
fun InstagramLayoutsPreview() {
    InstagramLayouts()
}