package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonStylingBootcamp () {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = {/*TODO*/},
            // Button Styling
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(255, 215, 0),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 10.dp,
                disabledElevation = 0.dp
            ),
            border = BorderStroke(1.dp, Color.LightGray),
        ) {
            Text("Button Style 1")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonStylingBootcampPreview () {
    Surface(modifier = Modifier.fillMaxSize()) {
        ButtonStylingBootcamp()
    }
}

// Small Summary
/*
Button Styling
Button styling di Jetpack Compose adalah proses mengubah tampilan visual tombol (seperti warna, ukuran, bentuk, padding, bayangan, dll.) agar sesuai dengan desain aplikasi kamu.
Styling ini sangat penting karena tombol merupakan komponen interaktif utama — dan harus selaras dengan branding atau UI/UX keseluruhan aplikasi.

Ada apa aja styling di button
enabled: Boolean -> Logic
shape: Shape -> Shaping,
colors: ButtonColors -> Warna
elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
border: BorderStroke? = null,
contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
interactionSource: MutableInteractionSource? = null,

*/