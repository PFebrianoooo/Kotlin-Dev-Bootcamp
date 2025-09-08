package com.putrapebrianonurba.kotlindevbootcamp.flows

import android.os.Bundle
import androidx.activity.ComponentActivity

class WritingFlows: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

// Small Summary
/*
Flows in Kotlin (COLD)
Flows merupakan sebuah pengaliran data yang ada paka android, kaitannya sangat erat sekali dengan MVVM Architecture dan fetching data.
flow seperti sequence di kotlin, tetapi pada sequece menggunakan singkronus. Sedangkan flow menggunakan asingkronus

Macam fungsi yang ada di flow
1. emit -> mengirimkan data ke flow
2. flow -> wadah untuk menampung data dan alirin data
3. collect { } -> menerima data dari flow (harus dengan coroutine)
*/