package com.putrapebrianonurba.kotlindevbootcamp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlertDialogBootcamp() {
    var showalert1 by remember { mutableStateOf(false) }
    var showalert2 by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Alert Dialog Bootcamp", fontSize = 28.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        Button(
            onClick = { showalert1 = true }
        ) {
            Text("Show AD Type 1")
        }
        Button(
            onClick = { showalert2 = true }
        ) {
            Text("Show AD Type 2")
        }
    }

    // Types of Alert Dialog
    if (showalert1) {
        AlertDialogOne(
            handleOnDismiss = { showalert1 = false },
            handleConfirmButton = {
                showalert1 = false
                // Add aditional actions here
                Log.d("Confirm Button", "Confirm Button Clicked")
            },
            handleDismissButton = {
                showalert1 = false
            }
        )
    }
    if (showalert2) {
        AlertDialogTwo(
            handleOnDismiss = { showalert2 = false },
            handleConfirmButton = {
                showalert2 = false
                // Add aditional actions here
                Log.d("Confirm Button", "Confirm Button Clicked")
            },
            handleDismissButton = {
                showalert2 = false
            }
        )
    }
}

// Basic Alert Dialog
@Composable
fun AlertDialogOne(handleOnDismiss: () -> Unit, handleConfirmButton: () -> Unit, handleDismissButton: () -> Unit) {
    AlertDialog(
        onDismissRequest = handleOnDismiss,
        confirmButton = { TextButton( onClick = handleConfirmButton ) { Text("Confirm") } },
        title = { Text("Alert Dialog Title") },
        text = { Text("Normal basic text is here!") },
        dismissButton = { TextButton(onClick = handleDismissButton) { Text("Cancel") } }
    )
}

@Composable
fun AlertDialogTwo(handleOnDismiss: () -> Unit, handleConfirmButton: () -> Unit, handleDismissButton: () -> Unit) {
    AlertDialog(
        onDismissRequest = handleOnDismiss,
        confirmButton = { TextButton( onClick = handleConfirmButton ) { Text("Confirm") } },
        icon = { Icon(imageVector = Icons.Default.Info, contentDescription = null) },
        title = { Text("Alert Dialog Title") },
        text = { Text("Normal basic text is here!\nyou can added more information in here if you want") },
        dismissButton = { TextButton(onClick = handleDismissButton) { Text("Cancel") } }
    )
}

@Preview(showBackground = true)
@Composable
fun AlertDialogBootcampPreview() {
     AlertDialogBootcamp()
}

// Small Summary
/*
Basic Alert Dialog Bootcamp
AlertDialog adalah komponen UI yang digunakan untuk menampilkan kotak dialog pop-up kepada pengguna, biasanya untuk memberikan informasi penting,
menampilkan peringatan, atau meminta konfirmasi sebelum melakukan suatu aksi.

Standard Lib Material 3
AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = AlertDialogDefaults.shape,
    containerColor: Color = AlertDialogDefaults.containerColor,
    iconContentColor: Color = AlertDialogDefaults.iconContentColor,
    titleContentColor: Color = AlertDialogDefaults.titleContentColor,
    textContentColor: Color = AlertDialogDefaults.textContentColor,
    tonalElevation: Dp = AlertDialogDefaults.TonalElevation,
    properties: DialogProperties = DialogProperties()
)

Penjelasan:
1. On Dismiss Request
   Sebuah lambda yang dipanggil ketika user dismiss the dialog, bisa di trigger ketika user menekan tombol back atau di luar dialog. Tidak akan dipanggil apabila menekan dismiss button
2. Confirm Button
   Sebuah button untuk konfirmasi, kita menggunakan TextButton disini
3. Modifier
   Modifier merupakan modifying layout untuk dialog
4. Dismiss Button
   Sebuah button untuk Dismiss (Cancel), kita menggunakan TextButton disini
5. Title
   Sebuah Judul untuk dialog, gunakan Text composable disini
6. Text
   Sebuah Deskripsi untuk aksi, gunakan Text composable disini
7. Shape
   bentuk Dari sebuah dialog, apakah rounded atau circle dsb
8. Icon
   Merupakan icon untuk alert, berada di atas Title, kita bisa pake ikon dari Vector image atau custom
9. Container Color
   Merupakan warna dari alert dialog
10. Icon Content Color
   Merupakan warna dari icon di dalam alert dialog poin no 8
11. Title Content Color
   Merupakan warna dari title di dalam alert dialog poin no 5
12. Text Content Color
   Merupakan warna dari text di dalam alert dialog poin no 6
13. Tonal Elevation
   Merupakan elevasi dari alert dialog berkaitan dengan warna bg dari alert dialog dan konten
14. Properties
   Additional Configuration Properties

*/
