package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FloatingActionButtonBootcamp() {
    Scaffold(
        // Bottom App Bar
        bottomBar = {
            BottomAppBar(containerColor = Color.Gray) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                    Text("Bottom App Bar", fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
                }
            }
        },
        // Floating Action Button
        floatingActionButton = {
            FloatingActionButton(
                onClick = {/*TODO*/},
                modifier = Modifier.padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                containerColor = Color.Gray.copy(alpha = 0.5f),
                contentColor = Color.White,
            ) {
                Row(modifier = Modifier.padding(10.dp)) {
                    Icon(Icons.Filled.Edit, contentDescription = null, modifier = Modifier.padding(end = 5.dp))

                    Text("Compose", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { innerPadding ->
        Text("Floating Action Button", modifier = Modifier.padding(innerPadding))

    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButtonBootcamp()
}

// Small Summary
/*
ada apa aja di floating action button
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = FloatingActionButtonDefaults.shape,
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit

Chore: Bagaimana membuat sebuah expandable FAB
*/