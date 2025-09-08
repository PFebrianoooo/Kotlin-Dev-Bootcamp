package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun ProducedStateBootcamp() {
    val number by produceState(initialValue = 5) {
        while (true){
            delay(1500)
            value = Random.nextInt(100)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Number $number")
    }
}

@Preview(showBackground = true)
@Composable
private fun ProducedStateBootcampPreview() {
    ProducedStateBootcamp()
}

// Small Summary
/*
Produced State
Produced State merupakan sebuah side effect API yang mengubah data non compose memnjadi data compose,
kasus ini bisa didapatkan ketika kita melakukan fetching api dan data tersebut berupa json, nah dari json tersebut
diubah menjadi nilai compose
"Membuat nilai state yang diproduksi dari asingkronus"


Cara lain kita bisa menggunakan state dengan bantuan launched effect, tetapi kode yang ditulis sangatlah
verbose dan boilerplate, maka dari itu produced state hadir sebagai solusi boiler plate tersebut

Kapan produced State digunakan?
1. Ngambil sebuah data tanpa ViewModel
2. Mencoba hasil response json tanpa ViewModel
3. Kalo datanya hanya di satu layar aja cocok banget

Contoh Penggunaan
@Serializable
data class Product (
    val id: Int,
    val title: String,
    val price: Double
)

@Composable
fun ProducedStateBootcamp() {
    val product by produceState<Product?>(null) {
        val json = Json { ignoreUnknownKeys = true }
        value = try {
            json.decodeFromString(Product.serializer(), URL("https://dummyjson.com/products/1").readText())
        } catch (e: Exception) {
            null
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (product == null) {
            CircularProgressIndicator()
        } else {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("ID: ${product!!.id}")
                Text("Title: ${product!!.title}")
                Text("Title: ${product!!.price}")
            }
        }
    }
}

Butuh Plugin & Liblary
    //Plugins
    kotlin("plugin.serialization") version "1.9.0"
    // JSON
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
*/