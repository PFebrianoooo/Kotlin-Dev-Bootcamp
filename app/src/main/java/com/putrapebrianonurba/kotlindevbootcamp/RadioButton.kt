package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RadioButtonBootcamp() {
    var state by remember { mutableStateOf(true) }

    RadioButton(
        selected = state,
        onClick = { state = false}
    )
}

@Preview(showBackground = true)
@Composable
private fun RadioButtonBootcampPreview() {
    RadioButtonBootcamp()
}

// Small Summary
/*
Radio Button
Radio Button merupakan sebuah opsi pilihan yang ada pada android yang mana, untuk memilih opsi a dsb. opsi
tersebut berfungsi untuk menjadi pilihan user.

Ada apa aja di radio button?
RadioButton(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors(),
    interactionSource: MutableInteractionSource? = null
) {args}
*/