package com.putrapebrianonurba.kotlindevbootcamp.flows

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class OperatorFlow: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Operator Flow 1
        runBlocking {
            counter()
                .filter { it.contains("This") } // Kita pilih kata yang hanya berisikan This saja
                .map { "$it + new Value" } // Mengubah value
                .collect { Log.d("Log Message", it) } // Getting
        }

        // Operator Flow 2
        runBlocking {
            counter2()
                .flatMapConcat {
                    flow {
                        delay(1000)
                        emit(it + 10)
                    }
                }
                .collect { Log.d("Log Message", it.toString()) }
        }

        // Operator Flow 3
        runBlocking {
            counter2()
                .flatMapLatest {
                    flow {
                        delay(1000)
                        emit(it + 10)
                    }
                }
                .collect { Log.d("Log Message", it.toString()) }
        }

    }
}

private fun counter(): Flow<String> {
    var count = 1
    val optionWord = listOf("This", "That")
    val options = optionWord.random()

    return flow {
        for (x in count.. 10) {
            emit("$options is $x Count: $count")
            delay(1000)
            count++
        }
    }
}

private fun counter2(): Flow<Int> {
    return flow {
        for (x in 1.. 10) {
            emit(x)
            delay(1000)
        }
    }
}

// Small Summary
/*
Flow Operator
Flow operator merupakan sebuah operasi yang ada pada flow, operator pada flow berguna sebaagi filtering data yang akan di tampilkan

Macam Operator Flow
Transformasi
1. .map{} Mengubah setiap item
2. .filter{} Memfilter data
3. take(n) mengambil data ke-n
4. transform{} emit beberapa item dalam satu input
5. FlatMapConcat{} Menggabungkan beberapa flow menjadi satu flow dalam sequence
6. flatMapLatest{} Mengammbil sebuah data hanya yang terbaru saja

Kombinasi
1. zip gabung dua flow atau lebih item per item
2. combine gabung dua flow atau lebih dan mengupdate apabila ada perubahan
3. merge gabung dua flow atau lebih tanpa urut

Control
1. debounce(timeMillis) tahan data, buang yang terlalu cepat
2. sampletime ambil snapshot tiap interval waktu
3. buffer() biar flow jalan lebih cepat secara asingkronus
4. conflate() skip value kalo collector lambat

Terminal Operator
1. collect {} ambil data
2. toList() ubah jadi list
3. first() ambil data pertama
4. single() ambil satu satunya item, kalo lebih error
5.

*/