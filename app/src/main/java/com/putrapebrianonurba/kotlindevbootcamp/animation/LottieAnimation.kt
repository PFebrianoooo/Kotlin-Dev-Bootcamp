package com.putrapebrianonurba.kotlindevbootcamp.animation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.putrapebrianonurba.kotlindevbootcamp.R

@Composable
fun LottieAnimationBootcamp(modifier: Modifier = Modifier) {
    // Raw data
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.sport_boy))

    // Lottie Anim
    var isPlaying by remember { mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(composition = composition, isPlaying = isPlaying)

    // Launched Effect
    LaunchedEffect(key1 = progress) {
        // When Runninng
        if (progress == 0f) isPlaying = true
        // When Not Running
        if (progress == 1f) isPlaying = false
    }


    Box(modifier.fillMaxSize().clickable(onClick = { isPlaying = true }), contentAlignment = Alignment.Center) {
        LottieAnimation(
            composition = composition,
            // iterations = LottieConstants.IterateForever,
            modifier = modifier.size(350.dp),
            progress = {
                progress
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LottieAnimationBootcampPreview() {
    LottieAnimationBootcamp()
}

// Small Summary
/*
Langkah - Langkah
1. Buka web lottie files
2. Cari filenya
3. taruh di file raw resource folder
4. Adding dependency

NB:
1. Untuk menjadikan splashscreen perlu navigation host dan inclusive true, buat hapus splash dari back stack
*/