package com.putrapebrianonurba.kotlindevbootcamp

import android.widget.Space
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonBootcamp() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            // Actions
        }) {
            Text("Normal Button")
        }

        OutlinedButton(onClick = {
            // Actions
        }) {
            Text("Outlined Button")
        }

        IconButton(onClick = {
            // Actions
        }) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "IconButton",
                tint = Color.Blue,
                modifier = Modifier.size(50.dp)
            )
        }

        TextButton(onClick = {

        }) {
            Text("Text Button")

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing.times(2)))

            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Plus",
                tint = Color.Blue,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
        }

        Button(onClick = {
            // Actions
        }) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Plus",
                tint = Color.White,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing.times(2)))

            Text("Normal Button")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ButtonBootcampPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ButtonBootcamp()
    }
}

// Small Summary
/*
Button Bootcamp
Button adalah salah satu composable yang digunakan untuk men-trigger aksi saat pengguna menekannya.
Ini termasuk dalam elemen interaktif paling dasar.

Syntax dasar
Button (modifier, onClick = {
    // action
}){
    // Element
}

Yang ada para button
Standard
onClick: () -> Unit,
modifier: Modifier = Modifier,
*/