package com.putrapebrianonurba.kotlindevbootcamp.coroutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CoroutinesMain: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GlobalScope.launch {
            Log.d("coroutine_tag", "globalScope: ${Thread.currentThread().name}")
            delay(3000)
            Log.d("coroutine_tag", "globalScope after delay: ${Thread.currentThread().name}")
        }

        lifecycleScope.launch {
            Log.d("coroutine_tag", "lifecycleScope: ${Thread.currentThread().name}")
        }

        Log.d("coroutine_tag", "On Create: ${Thread.currentThread().name}")
    }
}
// Small Summary
/*
Chit Chat
1. Dalam pengeksekusian sebuah kode, kode dieksekusi dari atas ke bawah up to bottom
2. Android sama seperti iOS yaitu MTE ( Multithread Enviroment ) yaitu memiliki banyak thread

What is coroutines
Coroutines merupakan sebuah proses asingkronus yang menjalankan/mengeksekusi sebuah task dalam thread yang berbeda secara angsingkronus.
Maksudnya adalah, menjalankan sebuah task dalam thread lain, agar thread main fokus pada rendering UI saja.

Kenapa ada coroutines?
Coroutines hadir sebagai solusi atas permasalahan yang memerlukan waktu eksekusi yang lebih banyak, misalkan dalam proses fetch data dari api atau
fteching data dari DB. agar proses tersebut tidak mengganggu pada saat rendering, kita pisahkan proses heavy tersebut ke dalam proses yang lain atau
dalam konteks ini thread lainnya, agar main thread fokus pada rendering dan tidak mengganggu proses proses lainnya.

Lifecycle Activity
Merupakan sebuah siklus hidup tampilan pada activity yang mana apabila activity destroy(tidak tampil di layar hp). maka semua coroutines yang ada
pada activity tersebut akan mati kecuali global scope

How to Running Coroutines
1. GlobalScope.launch { args }
   Globalscope merupakan scoping coroutines yang menjalankan thread lain yang tidak terikat lifecycle activity.
   Yang artinya apabila activity sudah destroy/tidak tampil di layar akan masih tetap hidup

   Kekurangan:
   1. Membuat memory leak, karena tidak tergantung siklus aplikasi.

2. lifecycleScope.launch { args }
   lifecycleScope merupakan scouping coroutines yang akan hidup apabila activity masih tampil di layar. dan akan mati apabila activity sudah tidak tampil
   di layar. Dalam kata lain, apabila tampil ui di layar hp, coroutine hidup apabila tidak tampil coroutine mati

*/