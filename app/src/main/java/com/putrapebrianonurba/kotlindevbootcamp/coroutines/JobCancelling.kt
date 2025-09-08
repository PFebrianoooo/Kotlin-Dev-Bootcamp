package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

class JobCancellingCoroutines: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val job = lifecycleScope.launch(Dispatchers.IO) {
            withTimeout(3000) { // dalam waktu yang di tentukan akan berhenti, walaupun tanpa ada cancel job
                for (i in 30 until 40) {
                    if (isActive) { // tanpa ini walaupun ada cancellation tetap jalan
                        val result = recursiveLucasNumber(i)
                        Log.d("TAG", "Result $i = $result")
                    }
                }
            }
        }

        // Kalo pake cancelling disini, tetap cancel, namun masih ada eksekusi lagi setelahnya
        // Join nunggu coroutine selesai, baru eksekusi kode after join
        runBlocking {
            // delay(2000)
            // job.cancel()
            job.join()
            Log.d("TAG", "Coroutine Cancelled")
        }
    }

    private fun recursiveLucasNumber(n: Int): Int {
        return when (n) {
         0 -> 2
         1 -> 1
         else -> recursiveLucasNumber(n -1) + recursiveLucasNumber(n + 2)
        }
    }
}

// Small Summary
/*
Job & Cancelling
> Job
Merupakan sebuah reference handle terhadap coroutines yang akan dijalankan. Jadi kita dapat handle coroutine tersebut dan melakukan tracking terhadap
coroutine tentu, berdasarkan user mau kemana. kita bisa cancelling job tersebut agar tidak terhadi leak memory dan mengganggu UX

> Cancelling
Merupakan sebuah proses membatalkan eksekusi sebuah coroutine yang belum selesai eksekusinya, apabila sebuah coroutine belum selesai eksekusinya
akan kita cancel, maka rest of the coroutine code tidak akan di jalankan.

Berguna banget kalo kita main ViewModel dengan reference coroutine ViewModelscope

Macam Penggunaan Coroutine job cancelling
1. withtimeOut() { args } memberi batasan waktu eksekusi
2. job.cancel() membatalkan langsung coroutine
3. job.join() nunggu coroutine selesai baru eksekusi kode
*/