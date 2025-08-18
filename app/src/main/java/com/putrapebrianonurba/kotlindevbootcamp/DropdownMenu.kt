package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DropdownMenuBootcamp() {
    var expandedMenu by remember { mutableStateOf(false) }
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            onClick = {
                expandedMenu = true
            }
        ) {
            Icon(Icons.Default.Menu, contentDescription = "menu")
        }

        DropdownMenu(
            expanded = expandedMenu,
            onDismissRequest = { },
            modifier = Modifier.padding(10.dp)
        ) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        selectedOptionText = it
                        expandedMenu = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DropDownMenuBoocampPreview() {
    DropdownMenuBootcamp()
}

// DropDownMenu
/*
Dropdown menu merupakan sebuah menu yang dapat muncul apabila di klik pada sebuah komponen. Dropdown menu muncul sementara
apabila pengguna sudah mengklik pada komponen yang bersangkutan.

Dropdown menu bekerja baik dengan scaffold khususnya top app bar
 */