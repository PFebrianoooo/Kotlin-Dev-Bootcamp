package com.putrapebrianonurba.kotlindevbootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.putrapebrianonurba.kotlindevbootcamp.ui.theme.KotlinDevBootcampTheme

class Introduction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinDevBootcampTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = "Introuction",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntrouctionPreview() {
    KotlinDevBootcampTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "Introuction",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

// Small Summary
/*
Introduction (Without XML)
Kotlin jetpack compose merupakan native ui yang digunakan untuk membuat sebuah ui dalam bahasa pemrograman kotlin yang berjalan di android.
Keunggulannya terletak pada kode yang lebih sedikit. Tetapi, memiliki fungsionalitas yang powerful.

Keuntungan dari jetpack compose
1. Tidak perlu menggunakan XML
2, Cepat
3. Performa yang sangat lancar
4. Mudah dipelajari
5. Using 100& Kotlin language

Compare xml Vs Jetpack
                Classic Android (XML)           Jetpack Compose
Paradigm       Imperative Approach             Declarative Approach
Scema          XML UI <-> Activity             Declarative UI -> App
                      App

Requirement to to this course
1. Knowledge Basic & OOPs Concept of Kotlin
2. Familiar with Android Studio
3. Android Studio Fox Version or Higher    
*/