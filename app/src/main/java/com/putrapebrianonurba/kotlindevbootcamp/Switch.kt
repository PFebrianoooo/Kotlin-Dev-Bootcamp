package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchBootcamp() {
    var switchIsActive by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(horizontal = 10.dp).statusBarsPadding(),
    ) {
        Text("Switch Bootcamp", fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 10.dp))

        repeat(10) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .border(0.5.dp, Color.Black, RoundedCornerShape(5.dp))
                    .padding(horizontal = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Hidupkan Switch on/off", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)

                Switch(
                    checked = switchIsActive,
                    onCheckedChange = { switchIsActive = it },
//                    colors = SwitchDefaults.colors(
//                        checkedBorderColor = Color.Red, // When Active
//                        checkedThumbColor = Color.Green,
//                        checkedTrackColor = Color.Blue,
//                        uncheckedBorderColor = Color.Blue, // When Inactive
//                        uncheckedThumbColor = Color.Green,
//                        uncheckedTrackColor = Color.Red
//
//                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_8", showSystemUi = true)
@Composable
fun SwitchBootcampPreview() {
    SwitchBootcamp()
}

// Small Summary
/*
Switch
Merupakan sebuah button yang memberikan response berupa bollean true or false.
Switch banyak di gunakan untuk setting pada hp

Switch Code
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    thumbContent: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    colors: SwitchColors = SwitchDefaults.colors(),
    interactionSource: MutableInteractionSource? = null,
)
*/