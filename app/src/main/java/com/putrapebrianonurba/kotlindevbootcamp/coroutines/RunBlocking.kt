package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RunBlockingCoroutines: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TAG", "OnCreate Starts")

        runBlocking {
            Log.d("Coroutine RunBlock", "Runblocking start")
            delay(4000)
            Log.d("Coroutine RunBlock", "Runblocking End")

            // Independently
            launch(Dispatchers.IO) {
                Log.d("Coroutine RunBlock IO", "Runblocking start 2")
                delay(4000)
                Log.d("Coroutine RunBlock IO", "Runblocking End 2")
            }

            // Tidak menunggu proses atasnya selesai baru dieksekusi
            Log.d("Coroutine RunBlock", "Runblocking start 3")
            delay(4000)
            Log.d("Coroutine RunBlock", "Runblocking End 3")
        }

        Log.d("TAG", "OnCreate End")
    }
}

// Small Summary
/*
RunBlocking
Runblocking merupakan salah satu coroutines yang memblok eksekusi task selanjutnya, task selanjutnya akan menunggu coroutine tersebut sampai
selesai baru eksekusi task selanjutnya. Runblocking akan memblokir main thread.
Biasanya penggunaan dari runblocking digunakan untuk testing. baik unit test atau end to end test.
runblocking hidup di main thread atau thread lainnya
*/