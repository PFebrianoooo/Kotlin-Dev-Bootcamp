package com.putrapebrianonurba.kotlindevbootcamp.mvvmarchitecture

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var count = 0

    fun incrementCounter() {
        count ++
    }
}

// Small Summary
/*
MVVM Architecture
1. Model
2. View
3. Model

> Model
Merupakan sebuah data model yang mana di representasikan dengan data class yang digunakan untuk membuat kerangka data.
Kerangka data yang digunakan ini dibuat berdasarkan response api.
Alat yang membantu membuat sebuah data model adalah Quicktype.io

> View
Merupakan sebuah tampilan aplikasi yang ditampilkan kepada pengguna. Berisi composable function yang akan di tampilkan
Data yang akan di tampilkan oleh View Model. dan data yang di kirimkan seperti on click input dan sebagainya.

> View Model
View Model merupakan sebuah jembatan anatara Model dengan View. Fungsi View Model adalah menangani flow data dan informasi yang akan di terima
dari view dan menampilkan data dari view

Activity Lifecycle
|Activity Opened| -> onCreate() -> onStart() -> onResume() -> |Activity Runnning| -> onPause() -> onStop() -> onDestroy()
*/