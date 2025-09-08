package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun RememberCoroutineScopeBootcamp() {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                scope.launch {
                    withContext(Dispatchers.IO) {
                        Log.d("Save to DB", "User data already saved to DB")
                        delay(3000)
                    }
                    Toast.makeText(context, "User data already saved to DB", Toast.LENGTH_SHORT).show()
                    Log.d("Save to DB", "User Database already saved")
                }
            }
        ) {
            Text("save to DB")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RememberCoroutineScopeBootcampPreview() {
    RememberCoroutineScopeBootcamp()
}

// Small Summary
/*
RememberCoroutineScope
Merupakan sebuah cara untuk menjalankan coroutine dalam composable function, karena macam lifecycleScope & GlobalScope tidak hidup di dalam composable function
RememberCoroutineScope hadir untuk mengatasi hal tersebut. siklus hidupnya seperti lifecycle scope, yaitu mengikuti daripada sebuah composable.
Secara Default, karena hidupnya di composable dispatcher nya udah auto Main Thread

composition -> Recomposition -> onDestroy
   Hidup    ->     Hidup     ->   Cancel

Kebanyakan remembercoroutinescope digunakan untuk menjalankan fungsi fungsi dari liblary yang ada yang membutuhkan coroutine untuk menjalankannya
banyak digunakan di dalam sebuah event handler yang meliputi
1. Click
2. Animation
3. SnackBar
4. Scroll
*/