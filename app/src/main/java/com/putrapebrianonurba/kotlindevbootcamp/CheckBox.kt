package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
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
fun CheckBoxBootcamp() {
    var checkBoxState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Checkbox(
            checked = checkBoxState,
            onCheckedChange = { checkBoxState = !checkBoxState }
        )

        Text("Apakah anda yakin untuk memilih ini!", modifier = Modifier.padding(end = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckBoxBootcampPreview() {
    CheckBoxBootcamp()
}

// Small Summary
/*
CheckBox Bootcamp
Checkbox merupakan sebuah komponen input yang digunakan untuk memilih opsi pilihan. Biasanya berbentuk kotak kecil
nah, kotak kecil tersebut, apabila belum dipilih maka akan kosong. Apabila sudah dipilih maka akan terisi
*/