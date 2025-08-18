package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModifierBootcamp() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Modifier Bootcamp",
            modifier = Modifier
                // .padding(10.dp) // Became margin if before bg
                .background(Color.Green)
                .padding(10.dp)
                // .fillMaxWidth()
                // .height(100.dp)
                .size(100.dp)
        )
        Text("Modifier Bootcamp",
            modifier = Modifier
                 .padding(10.dp) // Became margin if before bg
                .background(Color.Green)
                .padding(10.dp)
                // .fillMaxWidth()
                // .height(100.dp)
                .size(100.dp)
        )

        Box(modifier = Modifier
//            .rotate(45f)
            .padding(10.dp)
            .background(Color.Yellow)
            .alpha(0.9f)
            .size(100.dp)
            .border(1.dp, Color.Red, RoundedCornerShape(10.dp))
            .shadow(10.dp, RoundedCornerShape(10.dp), true)

        ){

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierBootcampPreview() {
    ModifierBootcamp()
}

// Small Summary
/*
Modifier Bootcamp
Modifier merupakan sebuah objek yang digunakan untuk memodifikasi atau mengatur tampilan, tata letak
perilaku dari composable

fungsi-fungsi pada modifier
1. Padding
2. Background
3. Size, width & Height
4. fill max width, height, size
5. align
6. border, shadow
7. graphics layer
8. offset
9. zindex
*/