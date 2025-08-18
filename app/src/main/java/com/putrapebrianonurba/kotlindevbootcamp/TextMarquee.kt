package com.putrapebrianonurba.kotlindevbootcamp

import android.widget.TimePicker
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TooltipBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextMarqueeBootcamp() {
    val text = "Text marquee Bootcamp Example \u0830\u0830 this is first emoji \u2665 second emoji \uD83D\uDE0A"

    Text(
        text = text,
        fontSize = 24.sp,
        maxLines = 1,
        modifier = Modifier
            .border(1.dp, Color.Black, RoundedCornerShape(10.dp))
            .padding(18.dp)
            .basicMarquee(
                iterations = Int.MAX_VALUE, // Repeat Forever
                animationMode = MarqueeAnimationMode.Immediately,
                repeatDelayMillis = 500,
                velocity = 200.dp
            )
    )

}

@Preview(showBackground = true)
@Composable
fun TextMarqueeBootcampPreview() {
    TextMarqueeBootcamp()
}

// Marquee text
/*
Marquee merupakan animasi basic dalam pembuatan text yang ada pada jetpack compose.
hasilnya seperti text yang bergerak dari kiri ke kanan atau sebaliknya
*/