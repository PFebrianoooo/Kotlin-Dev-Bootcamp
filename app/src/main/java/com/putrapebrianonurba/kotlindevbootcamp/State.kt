package com.putrapebrianonurba.kotlindevbootcamp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StateBootcamp() {
    // State variables
    var counter by remember { mutableStateOf(value = 0) }

    // Ui
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if (counter > 100) Text("Count: ${counter}") else Text("Counter Max, Resetto Immidiately")

        Spacer(modifier = Modifier.size(35.dp))

        Button(onClick = {
            counter ++
            Log.println(Log.INFO, "Increment Counter", "Counter: ${counter}")
        }) {
            Text("Counter")
        }

        Spacer(modifier = Modifier.size(15.dp))

        OutlinedButton(onClick = {
            counter = 0
            Log.println(Log.INFO, "Reset Counter", "Counter: ${counter}")
        }) {
            Text("Resetto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StateBootcampPreview() {
    StateBootcamp()
}

// Small Summary
/*
State & Recomposition
State merupakan sebuah variable yang di definisikan pada UI. STate berfungsi sebagai sebuah variable yang akan berubah dan memberikan
update hasil terbaru kepada UI

Standar penggunaan kode state harus di dalam remember
var variablesName by remember { mutableStateOf(initialValue) }

Perlu Diingat
1. State harus di dalam remember
2. Ketika mendefinisikan nilai dari state gunakan variableName.value. Jika tidak, akan berisi nilai alamatnya/referencenya/nilai aneh
   Mudahnya, menggunakan by untuk hilangkan variableName.Value dalam pemanggilan variable state di View
3. Boleh mendefinisikan tipe datanya, tetapi baiknya tidak perlu

*/