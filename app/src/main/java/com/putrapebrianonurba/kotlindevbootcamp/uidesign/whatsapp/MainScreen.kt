package com.putrapebrianonurba.kotlindevbootcamp.uidesign.whatsapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DoneAll
import androidx.compose.material.icons.filled.DonutSmall
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.DonutSmall
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MainScreen() {
    var selectedMenu by remember { mutableStateOf(0) }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopBar(modifier = Modifier.statusBarsPadding())
        },
        bottomBar = {
            BottomBar(
                modifier = Modifier.navigationBarsPadding(),
                selectedIcon = selectedMenu,
                onIconSelected = {index -> selectedMenu = index }
            )
        }
    )
    { innerPadding ->
        when(selectedMenu) {
            0 -> Content(modifier = Modifier.padding(innerPadding))
            1 -> AnotherContent("Updates Content", modifier = Modifier.padding(innerPadding))
            2 -> AnotherContent("Communities Content", modifier = Modifier.padding(innerPadding))
            3 -> AnotherContent("Calls Content", modifier = Modifier.padding(innerPadding))
        }
    }
}

// SCAFFOLD TOP & BOTTOM BAR
@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(50.dp)
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = modifier.background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            // Logo App
            Text(
                text = "WhatsApp",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )

            // Action Button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(Icons.Outlined.CameraAlt, contentDescription = "Camera", tint = Color.Black)

                Icon(Icons.Outlined.MoreVert, contentDescription = "MoreVert", tint = Color.Black)
            }
        }
    }
}

// Bottom Bar Icon data
private data class BottomNavIcon(
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val iconName: String
)

private val iconButton = listOf(
    BottomNavIcon(Icons.AutoMirrored.Filled.Chat, Icons.AutoMirrored.Outlined.Chat, "Chats"),
    BottomNavIcon(Icons.Filled.DonutSmall, Icons.Outlined.DonutSmall, "Updates"),
    BottomNavIcon(Icons.Filled.Groups, Icons.Outlined.Groups, "Communities"),
    BottomNavIcon(Icons.Filled.Call, Icons.Outlined.Call, "Calls"),
)

@Composable
private fun BottomBar(modifier: Modifier = Modifier, selectedIcon: Int, onIconSelected: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconButton.forEachIndexed { index, icons ->
            val bgColor by animateColorAsState(
                targetValue = if (selectedIcon == index) Color.Green.copy(alpha = 0.2f) else Color.Transparent,
                label = "bgAnim"
            )

            Column(
                modifier = modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = modifier
                        .size(55.dp, 30.dp)
                        .clip(RoundedCornerShape(percent = 50))
                        .clickable(onClick = { onIconSelected(index) })
                        .background(bgColor),
                    contentAlignment = Alignment.Center,
                ) {
                    if (selectedIcon == index) {
                        Icon(icons.iconSelected, contentDescription = icons.iconName, modifier = modifier.fillMaxSize(0.8f))
                    } else {
                        Icon(icons.iconUnselected, contentDescription = icons.iconName, modifier = modifier.fillMaxSize(0.8f))
                    }
                }

                Text(icons.iconName, fontWeight = if (selectedIcon == index) FontWeight.ExtraBold else FontWeight.Medium)
            }
        }
    }
}

// CONTENT SECTION
@Composable
private fun Content(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    val smoothScrolling = rememberLazyListState()

    LazyColumn(
        state = smoothScrolling,
        flingBehavior = rememberSnapFlingBehavior(lazyListState = smoothScrolling),
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            TextFieldPrimary(query, onValueChange = {query = it})
            ArchivedChats()
        }

        items(25) {
            RowChat()
        }
    }
}

@Composable
private fun TextFieldPrimary(search: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    // TextField
    TextField(
        value = search,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Ask Meta AI or Search",
                color = Color.Gray,
                fontSize = 16.sp
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Gray,
            )
        },
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(50)),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF0F2F5),
            unfocusedContainerColor = Color(0xFFF0F2F5),
            disabledContainerColor = Color(0xFFF0F2F5),
            errorContainerColor = Color(0xFFF0F2F5),

            // ini yg ngilangin underline
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,

            cursorColor = Color.Green,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        )
    )
}

@Composable
private fun ArchivedChats(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clickable(onClick = {})
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(40.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icon Archive
        Box(
            modifier = Modifier.width(55.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Outlined.Mail,
                contentDescription = "Archived",
                modifier = Modifier.size(20.dp),
                tint = Color.Black.copy(alpha = 0.5f)
            )
        }

        Text(
            text = "Archived",
            fontSize = 14.sp,
            color =  Color.Black.copy(alpha = 0.5f),
            modifier = modifier.padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "12",
            fontSize = 12.sp,
            color =  Color.Black.copy(alpha = 0.5f)
        )
    }
}

@Composable
private fun RowChat(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clickable(onClick = {})
            .padding(vertical = 10.dp, horizontal = 15.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Photo
        Image(
            painterResource(R.drawable.creator_photo),
            contentDescription = "Creator Photo",
            modifier = modifier.size(55.dp).border(1.dp, Color.Black, CircleShape).clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )

        // Name & Last Message
        Column(
            modifier = modifier.padding(start = 10.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text("Putra Pebriano Nurba", fontSize = 17.sp, fontWeight = FontWeight.Medium)

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Filled.DoneAll, contentDescription = "ReadMessage", modifier = modifier.size(12.dp), tint = Color.Blue)

                Text("This is Last message was sent to you.", fontWeight = FontWeight.Light, fontSize = 14.sp, color = Color.Gray)
            }
        }

        // Date & Time
        Text(
            text = "${SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())}",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = modifier.weight(1f).wrapContentSize(Alignment.CenterEnd)
        )
    }
}

@Composable
private fun AnotherContent(content: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(content, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}