@file:OptIn(ExperimentalMaterial3Api::class)

package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScaffoldBootcamp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Scaffold Bootcamp") })
        },
        bottomBar = {
            BottomAppBar {
                Text("Bottom App Bar")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add")
            }
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text("Scaffold Bootcamp")
            Text("Here is content must be placed")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScaffoldBootcampPreview() {
    ScaffoldBootcamp()
}

// Small Summary
/*
Scaffold
Scaffold Merupakan sebuah kontainer seperti layaknya columns, row, Card, Surface. Yang memebedakan scaffold dengan yang lainnya
Scaffold memberikan beberapa komponen yang terdisi di dalamnya adalah:
1. Top App Bar
2, Bottom navigation Bar
3. Floating Action button
4. Drawer Menu
5. Content itself

> Struktur dasar Scaffold
modifier: Modifier = Modifier,
topBar: @Composable (() -> Unit) = {},
bottomBar: @Composable (() -> Unit) = {},
snackbarHost: @Composable (() -> Unit) = {},
floatingActionButton: @Composable (() -> Unit) = {},
floatingActionButtonPosition: FabPosition = FabPosition.End,
containerColor: Color = MaterialTheme.colorScheme.background,
contentColor: Color = contentColorFor(containerColor),
contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
content: @Composable ((PaddingValues) -> Unit)
*/