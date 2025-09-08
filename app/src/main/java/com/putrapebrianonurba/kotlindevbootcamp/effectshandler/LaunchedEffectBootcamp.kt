package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LaunchedEffectBootcamp() {
    var counter1 by remember { mutableIntStateOf(0) }
    var counter2 by remember { mutableIntStateOf(0) }
    var counter3 by remember { mutableIntStateOf(0) }

    // Composition
    LaunchedEffect(Unit) {
        Log.d("LE-1", "running once when Composition called")
    }

    // Recomposition
    LaunchedEffect(key1 = counter1) {
        Log.d("LE-2", "running when recomposition or when state was changed!")
    }

    LaunchedEffect(key1 = counter2, key2 = counter3) {
        Log.d("LE-2", "running when recomposition or when one of the key state was changed!")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("Counter 1: $counter1")
                Text("Counter 2: $counter2")
                Text("Counter 2: $counter2\nCounter 3: $counter3")
            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
            ) {
                Button(
                    onClick = { counter1++ }
                ) {
                    Text("Increment 1")
                }

                Button(
                    onClick = { counter2++ }
                ) {
                    Text("Increment 2")
                }

                Button(
                    onClick = { counter3++ }
                ) {
                    Text("Increment 3")
                }
            }

            Button(
                onClick = {
                    counter1 = 0
                    counter2 = 0
                    counter3 = 0
                }
            ) {
                Text("Increment 3")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LaunnchedEffectBootcampPreview() {
    LaunchedEffectBootcamp()
}

// Small Summary
/*
Launched Effect
Launched Effect merupakan side effect api yang digunakan untuk memanggil coroutines(suspend) ke sebuah composable.
Dipanggil satu kali ketika composable masuk recomposition atau pertama kali composition. dan bisa running lagi kalo key nya berubah.
Launched Effect akan berubah apabila ada perubahan di dalam parameternya.
"Mirip onAppear dan onChange di Swift UI"

Lifecycle
Start -> apabila pertama kali masuk composition
Recompose -> Saat ada perubahan pada key (ReLaunch)
cancel -> saat composable dihapus dari composition

Param
1. Unit -> merupakan sebuah param yang hanya menjalankan ketika composition
2. key -> merupakan sebuah trigger untuk re launch coroutine, ketika ada perubahan maka akan re launch coroutine
          baik salah satu ataupun keduanya

Glosarium
1. Composition merupakan proses render pertama kali Composable
2. Recomposition merupakan proses render ulang Composable yang sudah ada
*/