package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SideEffectBootcamp() {
    var counter by remember { mutableIntStateOf(0) }

    SideEffect {
        // Always running when composition & recomposition happen
        Log.d("SE", "Counters number: $counter")
    }

    Button(onClick = {counter++}) { Text("Counter is $counter") }
}

@Preview(showBackground = true)
@Composable
private fun SideEffectBootcampPreview() {
    SideEffectBootcamp()
}

// Small Summary
/*
Side Effect
Side Effect merupakan sebuah sideEffect API yang digunakan untuk mengeksekusi kode setiap recomposition terjadi, kode tersebut dieksekusi diluar composable
saat pertama kali muncul di layar composition, side effect akan muncul. Dan ketika recomposition pun akan muncul.
Selalu muncul sesudah terjadi recomposition, baik secara unit ataupun variable yang diubah

Lifecycle
Start -> Running Side Effect
Recompose -> Running Side Effect lagi, jika ada perubahan pada parameter
*/