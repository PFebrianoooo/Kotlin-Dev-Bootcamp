package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineThread: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            // Doing in background
            getApiData() // Waiting until its done!
            Log.d("coroutine_tag", "Already get data in ${Thread.currentThread().name}")

            // Before this thread in background/IO
            withContext(Dispatchers.Main) {
                Log.d("coroutine_tag", "UPDATE data-1: in ${Thread.currentThread().name}")
            }
        }
    }

    private suspend fun getApiData() {
        delay(3000)
        Log.d("getApi_data", "API data with ${Thread.currentThread().name}")
    }
}

// Small Summary
/*
Coroutine Thread (Macam-Macam Thread)
Dalam thread yang ada pada coroutine ada beberapa macam thread yang diberikan oleh kotlin
1. Dispatcher.Main
2. Dispatcher.IO
3. Dispatcher.Default

1. Dispatcher.Main
   Dispatcher.Main Merupakan sebuah thread main/utama yang berguna untuk merender tampilan ui atau mengupdate tampilan UI
2. Dispatcher.IO
   Dispatcher.IO Merupakan sebuah thread pool khusus untuk operasi I/O seperti network request, read/write DB, file dan sebagainya.
   ada banyak thread yang tersedia di dalam Dispatcher.IO jadi cocok untuk operasi tunggu-tungguan
3. Dispatcher.Default
   Dispatcher.Default merupakan sebuah thread pool intensive yang akan melakukan tugas tugas yang berat seperti sorting, parsing json manual dan algoritma

*/