package com.putrapebrianonurba.kotlindevbootcamp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldToastBootcamp() {
    // State Variables
    var passwordInput by remember { mutableStateOf("") }
    val toastMessage = LocalContext.current
    val keyboardCloseController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(verticalArrangement = Arrangement.spacedBy(25.dp)) {
            // Normal
            TextField(value = passwordInput, onValueChange = { passwordInput = it },
                label = { Text("Enter Your Password") },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                placeholder = { Text("example@gmail.com") },
                visualTransformation = PasswordVisualTransformation(),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, tint = Color.Magenta, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = {
                        // Toast Implementation
                        Toast.makeText(toastMessage, passwordInput, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Done, contentDescription = null)
                    }
                }
            )

            OutlinedTextField(value = passwordInput,
                onValueChange = { passwordInput = it },
                label = { Text("Enter Your Password") },
                maxLines = 1,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                placeholder = { Text("example@gmail.com") },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Lock, tint = Color.Magenta, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = {
                        // Toast Implementation
                        Toast.makeText(toastMessage, passwordInput, Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Outlined.Done, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Send,
                    capitalization = KeyboardCapitalization.Characters
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        keyboardCloseController?.hide()
                        Toast.makeText(toastMessage, "Send Button Pressed", Toast.LENGTH_SHORT).show()
                        focusManager.clearFocus()
                    }
                )
            )

            BasicTextField(value = "Basic Text Field", onValueChange = { passwordInput = it })
        }
    }
}

@Composable
fun TextFieldTokPed() {
    // State variables
    var search by remember { mutableStateOf("") }

    // Keyboard
    val keyboardClose = LocalSoftwareKeyboardController.current

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            if(!search.isEmpty()){
                Icon(imageVector = Icons.Outlined.ArrowBack, tint = Color.Gray ,contentDescription = null, modifier = Modifier.padding(end = 10.dp).size(30.dp))
            }


            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = { Text("Cari di Tokopedia", fontSize = 14.sp) },
                modifier = Modifier.fillMaxWidth(0.9f).defaultMinSize(minHeight = 40.dp),
                textStyle = TextStyle(fontSize = 15.sp),
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Search, contentDescription = null)
                },
                shape = RoundedCornerShape(12.dp),
                trailingIcon = {
                    if (!search.isEmpty()) {
                        IconButton(onClick = {
                            search = ""
                        }) {
                            Icon(imageVector = Icons.Rounded.Clear, contentDescription = null)
                        }
                    }
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    if (!search.isEmpty()){
                        keyboardClose?.hide()
                        search = ""
                    }
                }),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedLeadingIconColor = Color.Gray,
                    unfocusedLeadingIconColor = Color.Gray,
                    focusedTrailingIconColor = Color.Gray,
                    unfocusedTrailingIconColor = Color.Gray
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldToastBootcampPreview() {
//    TextFieldTokPed()
    TextFieldToastBootcamp()
}

// Small Summary
/*
TextField & Toast Message Bootcamp
< TextField >
Merupakan sebuah cara untuk mengimput sebuah data ke dalam aplikasi, data yang didapatkan boleh apa aja

1. Textfield
   TextField(value = "Initial Value", onValueChange = {/*State Variables*/})
2. Outlined TextField
3. Basic TextField

Ada apa aja di paramnya
    value: String -> Digunakan untuk initial value,
    onValueChange: (String) -> Unit -> Digunakan untuk state variable,
    modifier: Modifier = Modifier -> Settingan layout TextField,
    enabled: Boolean = true -> Hidup/Matikan textfield,
    readOnly: Boolean = false -> apakah ini di baca doang/bisa diisi,
    textStyle: TextStyle = LocalTextStyle.current -> Style text pada textfield,
    label: @Composable (() -> Unit)? = null -> nama yang ada pada atas value,
    placeholder: @Composable (() -> Unit)? = null -> Contoh daripada sebuah input,
    leadingIcon: @Composable (() -> Unit)? = null -> icon yang terletak pada bagian depan/start,
    trailingIcon: @Composable (() -> Unit)? = null -> Icon yang terletak pada bagian belakang/end,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false -> animating apabila input salah,
    visualTransformation: VisualTransformation = VisualTransformation.None -> Tampilan visual, hide or not,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default -> Opsi Keyboard,
    keyboardActions: KeyboardActions = KeyboardActions.Default -> Opsi keyboard,
    singleLine: Boolean = false -> opsi jangan ngelebar ke bawah,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE -> Maximal line ke bawah,
    minLines: Int = 1 -> minimal baris,
    interactionSource: MutableInteractionSource? = null,
    shape: Shape = TextFieldDefaults.shape -> bentuk dari textfield,
    colors: TextFieldColors = TextFieldDefaults.colors() -> warna dari Textfield

< Toast Message >
Toast Message merupakan sebuah popup kecil yang berada di bawah layar yang digunakan untuk memberikan umpan
balik kepada pengguna.




*/