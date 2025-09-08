package com.putrapebrianonurba.kotlindevbootcamp.flows

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class CollectLatest: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            collectingUsername()
                .filter { it % 2 == 0 } // Genap
                // .collect { // Ke collect keseluruhan bil Genap
                .collectLatest {
                    delay(3000)
                    println("Collecting $it") // Ke collect only 10
                }
        }
    }
}

private fun collectingUsername(): Flow<Int> {
    return flow {
        for (x in 1.. 10)
        emit(x)
        delay(2000)
    }
}

// Small Summary
/*
Collect latest
Collect latest merupakan collecting data dalam flow yang hanya mengambil datanya hanya yang paling baru aja, sisa datanya di batalkan.
Sedangkan kalo collect menerima data tersebut secara mentah mentah
*/