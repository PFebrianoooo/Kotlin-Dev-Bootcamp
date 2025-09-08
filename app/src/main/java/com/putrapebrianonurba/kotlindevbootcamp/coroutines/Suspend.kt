package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Suspend: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Suspend type 1
//        GlobalScope.launch {
//            Log.d("coroutine_tag", "globalScope: ${Thread.currentThread().name}")
//            delay(3000)
//            Log.d("coroutine_tag", "globalScope after delay: ${Thread.currentThread().name}")
//        }

        // Suspend di dalam coroutine
        lifecycleScope.launch {
            getApiData1() // Rapihin ini dlu
            getApiData2() // Baru eksekusi ini
            // Kalo mau manggil tapi tunggu-tungguan
        }

        // Kalo mau manggil tanpa tunggu tungguan
        lifecycleScope.launch { getApiData1() }
        lifecycleScope.launch { getApiData2() }

    }

    // Suspend type 2
    private suspend fun getApiData1() {
        Log.d("fetch_api_data", "fetching data-1")
        delay(3000)
        Log.d("get_data", "getting data-1")
    }

    private suspend fun getApiData2() {
        Log.d("fetch_api_data", "fetching data-2") // execute
        delay(2000) // suspend
        Log.d("get_data", "getting data-2") // continue
    }
}

// Small Summary
/*
Suspend Function
Suspend function merupakan sebuah penundaan eksekusi, teknisnya penundaan eksekusi dapat dilakukan sehingga thread tersebut dapat dipakai oleh eksekusi yang lain
dan akan melanjutkan eksekusinya sesuai dengan suspend/penundaan
Suspend hanya dapat dipanggil di dalam coroutine, apabila diluar coroutine akan compile error

Macam-macam suspend
1. delay() (non Blocking)
   merupakan proses suspend/penundaan eksekusi sebuah task tanpa memblokir sebuah thread, jadi threadnya tetap jalan.
   Fungsi ini merupakan fungsi yang dapat dipanggil dari dalam coroutine dan pemanggilan dapat dipanggil dai dalam fungsi suspend

2. sleep() (non coroutine) (Blocking)
   Merupakan fungsi proses suspend/penundaan yang akan mengeksekusi sebuah task dan akan memblokir thread dalam waktu tertentu dan tidak bisa
   dipakai untuk eksekusi task lain.
   Misalkan kita buat thread sleep di main thread UI akan freeezing
*/