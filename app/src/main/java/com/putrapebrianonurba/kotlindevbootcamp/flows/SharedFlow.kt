package com.putrapebrianonurba.kotlindevbootcamp.flows

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext


class SharedFlow: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: SharedFlowViewModel = viewModel()

            InputScreenSharedFlow(viewModel)
        }
    }
}

@Composable
private fun InputScreenSharedFlow(viewModel: SharedFlowViewModel) {

    val inputValue by viewModel.inputValue.collectAsState()
    val localContext = LocalContext.current

    // Koleksi SharedFlow → tampilkan Toast
    LaunchedEffect(Unit) {
        viewModel.showToast.collect { msg ->
            Toast.makeText(localContext, "Data terkirim: $msg", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = inputValue,
            onValueChange = { viewModel.onInputChange(it) },
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (inputValue.isNotEmpty()){
                    viewModel.sendInputValue()
                    viewModel.sendMessageToast("Success Inputted Value")
                }
            }
        ) {
            Text("Send")
        }
    }
}

class SharedFlowViewModel: ViewModel() {
    private val _inputValue = MutableStateFlow("")
    val inputValue = _inputValue.asStateFlow()

    private val _showToast = MutableSharedFlow<String>()
    val showToast = _showToast.asSharedFlow()

    private val _channels = Channel<Int>()
    val channels = _channels.receiveAsFlow()

    fun sendMessageToast(message: String) {
        viewModelScope.launch {
            _showToast.emit(message)
        }
    }

    fun onInputChange(inputValue: String) {
        _inputValue.value = inputValue
    }

    fun sendInputValue() {
        Log.d("TAG", "sendInputValue: ${inputValue.value}")
        _inputValue.value = ""
    }
}

// Small Summary
/*
Shared Flow & Channel
> Shared Flow (HOT)
Shared flow merupakan sebuah property wrapper yang berada dalam view model, berbeda dengan state flow. Shared flow digunakan untuk memiliki data
tetapi data yang dimiliki tidak default, shared flow banyak digunakan untuk handle modal, snackbar, toast ataupun handle navigasi

Shared Flow tidak menyimpan sebuah property default, tapi kita bisa dapatkan event terakhir pakai "replay"

> Channel (COLD)
Channel merupakan sebuah property yang ada pada kotlin yang memuungkindan mengirim data apabila ada yang collect saja, apabila data tidak ada yang collect.
maka data tidak akan di emit, tunggu collect dlu baru di emit kemudian.



*/
