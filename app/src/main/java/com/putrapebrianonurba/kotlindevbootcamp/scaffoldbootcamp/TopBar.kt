package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.kotlindevbootcamp.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopBarBootcamp() {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(12.dp).clip(RoundedCornerShape(10.dp)),
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Top App Bar")
                    }
                },
                navigationIcon = {
                    Image(painter = painterResource(R.drawable.creator_photo), contentDescription = "Company_Logo", modifier = Modifier.size(40.dp))
                },
                actions = {
                    IconButton(onClick = {/* action here */}) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Menu")
                    }

                    BadgedBox( badge = { Badge(modifier = Modifier.size(10.dp)) {  } }) {
                        IconButton(onClick = {/* action here */}) {
                            Icon(imageVector = Icons.Default.Person, contentDescription = "Menu")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                     containerColor = Color.Magenta.copy(alpha = 0.15f),
                    // scrolledContainerColor = Color.Unspecified,
                    // navigationIconContentColor = Color.Unspecified,
                    // titleContentColor = Color.Unspecified,
                    // actionIconContentColor = Color.Unspecified,
                )
            )
        }
    ) { innerPadding ->

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarBootcampPreview() {
    TopBarBootcamp()
}

// Small Summary
/*
> Top App Bar ada apa aja di lambda
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    expandedHeight: Dp = TopAppBarDefaults.TopAppBarExpandedHeight,
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null
*/