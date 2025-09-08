package com.putrapebrianonurba.kotlindevbootcamp.flows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue


class StateFlow: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Referencing VM
            val viewModel: StateFlowViewModel = viewModel()

            InputScreen(viewModel)
        }
    }
}

@Composable
private fun InputScreen(viewModel: StateFlowViewModel) {
    // Referencing State
    val usernameState by viewModel.usernameState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(usernameState)

        TextField(
            value = usernameState,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = { Text("Username") }
        )
    }
}

class StateFlowViewModel: ViewModel() {
    // Jadi kalo ada 4 input kita bikin 4 gini
    // kalo mau lebih rapi pake dataClass
    private val _username = MutableStateFlow("") // Mutable, just for in viewModel
    val usernameState = _username.asStateFlow() // Exposed ke UI

    fun onUsernameChange(text: String) {
        _username.value = text
    }
}

// Small Summary
/*
Hot Stream & Cold Stream
> Hot Stream
Merupakan sebuah data yang menampilkan data terbaru tanpa di collect, misalkan user input nama ke textfield

> Cold Stream
Merupakan data yang hanya di produksi ketika ada yang collect, kalo gaada yang collect datanya tidak ada. Contohnya fetching api
kalo data flow nya gaada yang fetching datanya tidak ada.

State Flow (HOT)
State Flow merupakan sebuah upaya untuk membuat sebuah state dalam view model, dalam arsitektur MVVM viewmodel sebagai orchestrator dari kode kode yang
ada di UI, jadi jangan buat State di UI buat state di VM agar rapi.
State flow menerima data yang selalu update dengan UI sama seperti state pada umumnya

Kapan Stateflow digunakan
1. Menyimpan state UI yang berubah-ubah
    Contoh: daftar produk, status loading, error message, form input.
            StateFlow akan selalu menyimpan nilai terakhir sehingga saat UI recomposition atau activity/fragment recreate, data tetap tersedia.
2. Data yang bersifat “hot”
    Artinya, StateFlow selalu aktif dan menyimpan state terakhir, berbeda dengan Flow biasa yang “cold” dan hanya jalan saat dikoleksi.
3. Menghubungkan ViewModel dengan Compose atau UI
    collectAsState() di Jetpack Compose otomatis memobservasi StateFlow → UI recomposition otomatis saat state berubah.
4. Saat ingin menggantikan LiveData modern
    Di banyak proyek Android modern, StateFlow menggantikan LiveData karena lebih konsisten dengan coroutines dan Compose.
5. Kasus update data yang sering atau realtime
    Misal: daftar produk dari API yang bisa berubah (penambahan/hapus), status notifikasi, atau filter UI yang berubah-ubah.
 */