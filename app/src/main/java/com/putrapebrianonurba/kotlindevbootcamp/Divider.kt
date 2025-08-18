package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DividerBootcamp() {
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        repeat(10) {
            Text("Hello Divider Bootcamp $it", modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))

            HorizontalDivider(color = Color.Gray, thickness = 1.dp)
            // VerticalDivider(color = Color.Gray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DividerBootcampPreview() {
    DividerBootcamp()
}