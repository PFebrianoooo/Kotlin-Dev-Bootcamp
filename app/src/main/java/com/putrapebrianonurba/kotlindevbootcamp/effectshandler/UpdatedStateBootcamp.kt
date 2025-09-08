package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun UpdatedStateBootcamp() {
    var name by remember { mutableStateOf("Someone") }


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                "Hello $name",
                modifier = Modifier
                    .clickable {
                        name = "Putra"
                    }
            )

            Text(
                "Hello $name",
                modifier = Modifier
                    .clickable {
                        name = "Pebriano"
                    }
            )

            childViewUpdatedState(name)
        }
    }
}

@Composable
private fun childViewUpdatedState(name: String) {
    val nameUpdated by rememberUpdatedState(name) // solusi

    print("From Composable $nameUpdated")

    // Tanpa menggunakan remember updated state
    // value akan tetap menjadi someone
    // Walaupun kita ubah, tetap recompose tapi nilai yang dikenal hanya someone
    LaunchedEffect(Unit) {
        delay(3000)
        print("From LaunchedEffect $nameUpdated")
    }
}

@Preview(showBackground = true)
@Composable
private fun UpdatedStateBootcamp1Preview() {
    UpdatedStateBootcamp()
}

// Small Summary
/*
RememberUpdatedState
Remember updated state merupakan sebuah effect API yang digunakan untuk menyimpan referensi nilai terbaru dari suatu state atau parameter.
Tanpa remember updates state, apabila data di kirimkan ke unit composable lainnya apabila tidak menggunakan remember updated state, maka nilai tidak akan berubah
*/