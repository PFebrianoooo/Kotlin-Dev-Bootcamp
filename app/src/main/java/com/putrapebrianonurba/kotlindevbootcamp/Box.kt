package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxBootcamp() {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.TopStart) {
        Box(modifier = Modifier.height(800.dp).fillMaxWidth(0.9f).background(Color.Green), contentAlignment = Alignment.TopCenter) {
            Box(modifier = Modifier.height(700.dp).fillMaxWidth(0.9f).background(Color.Blue), contentAlignment = Alignment.TopEnd) {
                Box(modifier = Modifier.height(600.dp).fillMaxWidth(0.9f).background(Color.Yellow), contentAlignment = Alignment.CenterStart) {
                    Box(modifier = Modifier.height(500.dp).fillMaxWidth(0.9f).background(Color.Magenta), contentAlignment = Alignment.Center) {
                        Box(modifier = Modifier.height(400.dp).fillMaxWidth(0.9f).background(Color.Gray), contentAlignment = Alignment.CenterEnd) {
                            Box(modifier = Modifier.height(300.dp).fillMaxWidth(0.9f).background(Color.Cyan), contentAlignment = Alignment.BottomStart) {
                                Box(modifier = Modifier.height(200.dp).fillMaxWidth(0.9f).background(Color.White), contentAlignment = Alignment.BottomCenter) {
                                    Box(modifier = Modifier.height(100.dp).fillMaxWidth(0.9f).background(Color.Black), contentAlignment = Alignment.BottomEnd) {
                                        Text("Box Learning", color = Color.White)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxBootcampPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        BoxBootcamp()
    }
}

// Small Summary
/*
Box (Z Coordinates)
Box merupakan sebuah pengaturan posisi stacking yang mana posisinya menumpuk ke depan atau z-index
Secara default posisinya adalah topStart

Syntax Dasar
Box(Param) {
    Args
}

Apa aja sih yang ada pada param?
1. Modifier -> Merupakan layout styling dari composable
2. ContentAlignment -> Merupakan alignment dari isi dari composable/layout children
3. propagateMinConstraint -> Meneruskan minimum dan maksimum layout styling dari modifier

Content Alignment
1. TopStart -> Menempatkan komponen di kiri atas
2. TopCenter -> Menempatkan komponen di tengah atas
3. TopEnd -> Menempatkan komponen di kanan atas
4. CenterStart -> Menempatkan komponen di kiri tengah
5. Center -> Menempatkan komponen di tengah
6. CenterEnd -> Menempatkan komponen di kanan tengah
7. BottomStart -> Menempatkan komponen di kiri bawah
8. BottomCenter -> Menempatkan komponen di tengah bawah
9. BottomEnd -> Menempatkan komponen di kanan bawah
*/