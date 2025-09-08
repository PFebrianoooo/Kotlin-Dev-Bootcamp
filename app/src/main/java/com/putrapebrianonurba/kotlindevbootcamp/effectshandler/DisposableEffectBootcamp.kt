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
import androidx.compose.runtime.DisposableEffect
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
fun DisposableEffectBootcamp() {
    var counter1 by remember { mutableIntStateOf(0) }
    var counter2 by remember { mutableIntStateOf(0) }
    var counter3 by remember { mutableIntStateOf(0) }

    // Composition
    DisposableEffect(Unit) {
        Log.d("DE-1", "running once when Composition called")

        onDispose {
            Log.d("DE-1", "onDispose called, calling when composable is removed from composition")
        }
    }

    // Recomposition
    DisposableEffect(key1 = counter1) {
        Log.d("DE-2", "running when recomposition or when state was changed!")

        onDispose {
            Log.d("ONDISPOSE-DE-2", "running when recomposition or when state was changed!")
        }
    }

    DisposableEffect(key1 = counter2, key2 = counter3) {
        Log.d("DE-3", "running when recomposition or when one of the key state was changed!")

        onDispose {
            Log.d("ONDISPOSE-DE-3", "running when recomposition or when state was changed!")
        }
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
fun DisposableEffectBootcampPreview() {
    DisposableEffectBootcamp()
}

// Small Summary
/*
Disposable Effect
Disposable Effect merupakan side effect api yang upgrade dari Launched Effect. Yang ditambahkan fungsi onDispose.
onDispose merupakan sebuh fungsi yang akan di panggil ketika composable dihapus dari composition.
onDispose wajib dipanggil ketika kita menggunakan disposable effect

Lifecycle
Start -> apabila masuk pertama kali ke reecomposition
reLaunch -> running lagi apabila ada perubahan pad key
cancel -> saat composable dihapus dari composition dan running onDispose

Param
1. Key -> Merupakan sebuah trigger untuk re launch coroutine, ketika ada perubahan maka akan re launch coroutine
2. Unit -> merupakan trigger jalan hanya satu kali ketika composable masuk ke composition
3. onDispose -> merupakan sebuah fungsi yang akan di panggil ketika composable dihapus dari composition
                OnDispose akan selalu di panggil apabila ada key yang di watch
                Perubahan -> Running Disposable -> running onDispose -> Kembali ke perubahan


Chit - Chat
1. Tidak disarkankan digunakan pada onClick/event listener. Contoh untuk pembelajaran saja!
*/