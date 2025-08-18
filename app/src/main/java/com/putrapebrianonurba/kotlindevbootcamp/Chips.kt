package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
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
fun ChipsBootcamp() {
    var selectedFilterChip by remember { mutableStateOf(false) }
    var selectedInputChip by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        // Assist Chip
        AssistChip(
            onClick = {
                // Action Here
            },
            label = {
                Text("Assist Chip")
            },
            leadingIcon = {
                Icon(Icons.Default.Settings, contentDescription = "settings")
            }
        )

        // Filter Chip
        FilterChip(
            selected = selectedFilterChip,
            label = {
                Text("Filter Chip")
            },
            onClick = {
                
            },
            leadingIcon = {
                if (selectedFilterChip) {
                    Icon(Icons.Default.Check, contentDescription = "check")
                } else {
                    Icon(Icons.Default.Clear, contentDescription = "clear")
                }
            }
        )

        // Input Chip
        InputChip(
            selected = selectedInputChip,
            label = {
                Text("Input Chip")
            },
            onClick = {
                selectedInputChip = !selectedInputChip
            },
            avatar = {
                Icon(
                    Icons.Default.Info,
                    contentDescription = "info",
                    modifier = Modifier.size(InputChipDefaults.IconSize)
                )
            }
        )

        // Suggestion Chip
        SuggestionChip(
            onClick = {

            },
            label = { Text("Suggestion Chip") },
            icon = {
                Icon(Icons.Default.Info, contentDescription = "info")
            }
        )

        // Arranged Chips With Flow
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ){
            repeat(10) {
                AssistChip(
                    onClick = {},
                    label = { Text("Assist Chip") },
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }

        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top)
        ) {
            repeat(10) {
                AssistChip(
                    onClick = {},
                    label = { Text("Assist Chip flow $it") },
                    modifier = Modifier.padding(horizontal = 4.dp).align(Alignment.CenterVertically)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChipsBootcampPreview() {
    ChipsBootcamp()
}

// Small Summary
/*
Chips Bootcamp
Chips Merupakan sebuah komponen kecil yang berbentuk oval/kapsul. yang berisi teks, ikon, atau keduanya.
Chips, dipakai untuk menampilkan informasi singkat yang berupa:
1. Informasi singkat
2. Input
3. Filtering
4. aksi cepat

Chips ada apa aja si?
1. Assist Chip
2. Filter Chip
3. Input Chip
4. Suggestion Chip
*/