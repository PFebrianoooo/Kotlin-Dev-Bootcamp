package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
private fun ColumnRowBootcamp() {
    // Column
    /*
    Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceBetween) {
        Text("First Text Appear", fontSize = 25.sp)
        Text("Overlapping Text")
        Text("First Text Appear", fontSize = 25.sp)
        Text("Overlapping Text")
        Text("First Text Appear", fontSize = 25.sp)
    }
    */

    // Row
    Row(horizontalArrangement = Arrangement.Absolute.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
        Text("First Text Appear")
        Text("Overlapping Text")
        Text("First Text Appear")
    }

}

@Preview(showBackground = true)
@Composable
private fun ColumnRowBootcampPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ColumnRowBootcamp()
    }
}

// Small Summary
/*
Row & Column
Merupakan metode stancking yang ada pade jetpack compose, secara default. Setelan stacking pada jetpack dalam mode box
yang mana rata ke depan

Yang membedakan?
Yang memebdakan antara column dan row adalah paramnya, kalo di row horizontalArrangement dan vertical alignment
sedangkan, pada Column horizontalAlingment dan verticalArrangement (Lawannnya Row)
*/
/*
> Column (Y Coordinates)
merupakan metode stacking yang menyusun elemen kedalam satu kolom atau Vertically

Syntax Dasar
Column(param) {
    Args
}

Dalam param row terdisi atas
1. modifier -> Merupakan layout styling dari composable
2. horizontalAlignment -> Merupakan alignment dari isi dari composable/layout children
3. verticalArrangement -> Merupakan arrangement dari isi dari composable/layout children

Horizontal Alignment
1. Start -> Menempatkan komponen di kiri
2. End -> Menempatkan komponen di kanan
3. CenterHorizontally -> Menempatkan komponen di tengah secara horizontal

Vertical Arrangement
1. Top -> Menempatkan komponen di atas
2. Bottom -> Menempatkan komponen di bawah
3. Center -> Menempatkan komponen di tengah secara vertical
4. SpaceAround -> Menempatkan komponen dengan jarak yang sama secara atas bawah, tengah Sama (Ada jarak atas bawah)
5. SpaceEvenly -> Menempatkan komponen dengan jarak yang sama secara rata rata
6. SpaceBetween -> Menempatkan komponen dengan jarak yang sama secara atas bawah, tengah sama (Gaada Jarak atas bawah)
*/
/*
> Row (X Coordinates)
Merupakan metode stacking yang menyusun elemen kedalam satu baris atau Horizontally

Syntax Dasar
Row(param) {
    Args
}

Isi dari param apa aja sih?
1. Horizontal Arrangement -> Merupakan arrangement dari isi dari composable/layout children
2. Vertical Alignment -> Merupakan alignment dari isi dari composable/layout children
3. Modifier -> Merupakan layout styling

Horizontal Arrangement
1. Start -> Menempatkan elemen berada di kiri
2. End -> Menempatkan elemen berada di kanan
3. Center -> Menempatkan elemen berada di tengah secara horizontal
4. SpaceAround -> Menempatkan komponen dengan jarak yang sama secara kiri kanan, tengah Sama (Ada jarak kiri kanan)
5. SpaceEvenly -> Menempatkan komponen dengan jarak yang sama secara rata rata
6. SpaceBetween -> Menempatkan komponen dengan jarak yang sama secara kiri kanan, tengah sama (Gaada Jarak kiri kanan)

Vertical aligment
1. Start -> Menempatkan komponen di kiri
2. End -> Menempatkan komponen di kanan
3. CenterHorizontally -> Menempatkan komponen di tengah secara vertical
*/