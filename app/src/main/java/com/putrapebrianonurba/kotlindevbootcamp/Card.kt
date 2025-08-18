package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardBootcamp() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(modifier = Modifier
            .height(270.dp)
            .width(200.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            border = BorderStroke(1.dp, color = Color.Gray),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            // CONTENT
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // IMAGES
                Image(painterResource(id = R.drawable.creator_photo), contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillBounds
                    )

                // DESCRIPTIONS
                Column(modifier = Modifier.padding(top = 5.dp, start = 10.dp, end = 10.dp)) {
                    Text("Putra Pebriano Nurba", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

                    Text("Descriptions in here about the creator of the file and courses", fontSize = 12.sp, fontWeight = FontWeight.Light, maxLines = 2)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardBootcampPreview() {
    CardBootcamp()
}

// Small Summary
/*
Card Bootcamp
Card merupakan sebuah wadah atau container yang memiliki tampilan seperti kartu, biasanya memiliki elevasi, sudut
dan bayangan. Card cocok untuk membuat bungkusan teks dan juga image.

Card Memiliki Struktur kode standar di bawah ini
Card(param) {
    Args
}

Paramnya berisi apa?
modifier: Modifier = Modifier,
shape: Shape = CardDefaults.shape,
colors: CardColors = CardDefaults.cardColors(),
elevation: CardElevation = CardDefaults.cardElevation(),
border: BorderStroke? = null,
*/