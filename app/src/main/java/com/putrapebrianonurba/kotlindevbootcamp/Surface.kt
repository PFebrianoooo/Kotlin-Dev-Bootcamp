package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.putrapebrianonurba.kotlindevbootcamp.ui.theme.KotlinDevBootcampTheme

@Composable
fun SurfaceBootcamp() {
    Surface(
        modifier = Modifier.height(150.dp).width(300.dp).padding(10.dp),
        color = Color.Green,
        shape = RoundedCornerShape(percent = 10),
        contentColor = Color.Red,
        tonalElevation = 100.dp,
        shadowElevation = 15.dp,
        border = BorderStroke(width = 1.dp, color = Color.Red)
    ) {
        Text("Putra Pebriano Nurba on Surface Bootcamp", fontSize = 20.sp, modifier = Modifier.padding(horizontal = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SurfaceBootcampPreview() {
    KotlinDevBootcampTheme {
        SurfaceBootcamp()
    }
}

// Small Summary
/*
Surface Bootcamp
Surface merupakan sebuah container dasar yang digunakan untuk membungkus UI. Fungsi utamanya sebagai layouting
isi daripada args, bisa berupa elemen komponen lainnya seperti text, button, etc

Standard Code
Surface (param) {
    Args
}

Param ada apa aja
1. modifier -> layout styling dari composable seperti padding, margin, size, alignment etc
2. shape -> bentuk dari surface seperti rounded, square, etc
3. color -> warna background dari surface seperti red, green, blue etc
4. contentColor -> warna dari content/isi dari surface seperti ikon atau teks
5. tonalElevation -> menambahkan ketebalan warna latar belakang
6. shadowElevation -> menambahkan efek bayangan visual (shadow) untuk lapisan atas
7. borderStroke -> memberikan garis tepi/bingkai

*/

// Scaffold
/*
Scaffold merupakan sebuah layout yang menyediakan komponen UI standar yang umum dipakai.
Kapan digunakan? saat kita ingin menyusun halaman lengkap daripada sebuah aplikasi.

Modifier ada apa aja?
1. Menentukan ukuran → width(), height(), fillMaxSize()
2. Memberi padding/margin → padding()
3. Mengatur posisi → align(), offset()
4. Menambahkan efek visual → background(), border(), shadow()
5. Membuat interaksi → clickable(), pointerInput()
6. Menangani gesture & scroll → scrollable(), draggable()

// Scaffold
Standard UI Component Liblary
1. modifier -> Merupakan layout styling dari composable
2. TopBar => Merupakan sebuah navbar top di mobile
3. Bottombar => Merupakan sebuah navbar bottom di mobile
4. SnackbarHost => Merupakan sebuah alert
5. floatingActionButton =>  Merupakan sebuah tombol yang tidak terpengaruh dari tampilan ui di belakangnya
6. floatingActionButtonPosition -> Merupakan posisi dari floating action button
7. ContainerColor -> warna dari container/surface
8. ContentColor -> warna dari content/isi dari surface
9. contentWindowInset -> jarak dari content ke window

Basic Code
Scaffold (Standard UI Component Liblary) { paddingVar ->
    Args
}
*/