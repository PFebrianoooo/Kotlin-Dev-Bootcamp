package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class AsyncAwaitCoroutines: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cara seperti ini membutuhkan waktu yang lebih banyak karena menunggu proses dahulu
        // 8 Millis executing time
        /*
        lifecycleScope.launch(Dispatchers.IO) {
            val requiredTime = measureTimeMillis {
                val apiData = fetchApiData()
                val tokenData = fetchTokenApiData()

                Log.d("TAG", "API Data: $apiData")
                Log.d("TAG", "Token Data: $tokenData")
            }

            Log.d("Time Millis", "Required Time to Execute: ${requiredTime}")
        }
        */

        // Cara seperti ini mendapatkan waktu eksekusi 4 millis
        // karena membuat independen fetching
        /*
        lifecycleScope.launch(Dispatchers.IO) {
            val requiredTime = measureTimeMillis {
                var apiData: String? = null
                var tokenData: String? = null

                val fetchApiDataNetwork = launch { apiData = fetchApiData() }
                val fetchTokenApiNetwork = launch { apiData = fetchTokenApiData() }

                fetchTokenApiNetwork.join()
                Log.d("TAG", "API Data: $apiData")
                fetchTokenApiNetwork.join()
                Log.d("TAG", "Token Data: $tokenData")
            }

            Log.d("Time Millis", "Required Time to Execute: ${requiredTime}")
        }
        */

        // Best Practice
        // Berjalan secara paralel
        // Work independently, tidak tunggu tungguan
        lifecycleScope.launch(Dispatchers.IO) {
            val requiredTime = measureTimeMillis {
                var apiData = async { fetchApiData() }
                var tokenData = async { fetchTokenApiData() }

                val apiDataResult = apiData.await()
                val tokenDataResult = tokenData.await()

                Log.d("TAG", "API Data: $apiDataResult")
                Log.d("TAG", "Token Data: $tokenDataResult")
            }

            Log.d("Time Millis", "Required Time to Execute: ${requiredTime}")
        }
    }

    private suspend fun fetchApiData(): String {
        delay(3000)
        return "API Data already fetched"
    }

    private suspend fun fetchTokenApiData(): String {
        delay(3000)
        return "TOKEN API Data already fetched"
    }
}

// Small Summary
/*
Async & Await
Async Await merupakan sebuah corutine builder yang menjalankan task secara paralel, async await memberikan janji yang pasti akan memiliki hasil
hasilnya berupa deferred<T>. dipakai ketika kita inginkan hasil balik dari sebuah coroutine.

Async dipanggil ketika menarik datanya sedangkan await dipakai untuk return hasil datanya.
*/