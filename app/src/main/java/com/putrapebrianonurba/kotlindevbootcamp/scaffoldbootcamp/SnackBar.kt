package com.putrapebrianonurba.kotlindevbootcamp.scaffoldbootcamp

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SnackBarBootcamp() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
         SnackbarHost(hostState = snackbarHostState) { messageData ->
             // Customize the snackbar appearance
             Snackbar {
                 Text(
                     messageData.visuals.message,
                     maxLines = 2,
                     overflow = TextOverflow.Ellipsis
                 )
             }
         }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    // action when FAB is clicked
                    // Log.d("Confirm Button", "Confirm Button Clicked")

                    // scope.launch { snackbarHostState.showSnackbar(
                        // message = "Your email already deleted",
                        // actionLabel = "Undo",
                        // withDismissAction = true,
                        // duration = SnackbarDuration.Indefinite
                    // ) }

                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "Snackbar",
                                actionLabel = "Action",
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                /* Handle snackbar action performed */
                            }
                            SnackbarResult.Dismissed -> {
                                /* Handle snackbar dismissed */
                            }
                        }
                    }
                }
            ) { Text("Show Snackbar") }
        }
    ) { innerPadding ->
        Text("SnackBar Bootcamp", modifier = Modifier.fillMaxSize().padding(innerPadding))
    }

}

@Composable
private fun SnackBarWithActions() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show Snackbar") },
                icon = {  },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "Snackbar",
                                actionLabel = "Action",
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                /* Handle snackbar action performed */
                            }
                            SnackbarResult.Dismissed -> {
                                /* Handle snackbar dismissed */
                            }
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Text("", modifier = Modifier.padding(innerPadding))
    }

}

@Preview(showBackground = true)
@Composable
fun SnackBarBootcampPreview() {
    SnackBarBootcamp()
    // SnackBarWithActions()
}