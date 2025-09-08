package com.putrapebrianonurba.kotlindevbootcamp.effectshandler

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@Composable
fun SnapshotFlowBootcamp() {
    val listState = rememberLazyListState()

    // Melakukan pengamatan terhadap listState
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            // Taruh Flow Operator Disini
            .filter { it > 0 }
            .distinctUntilChanged() // mencegah pengiriman data yang sama/duplicate
            .collect {
                print("The Value state: $it")
            }
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(count = 100) {
            Text(text = "Item $it", modifier = Modifier.padding(vertical = 15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnapshotFlowBootcampPreview() {
    SnapshotFlowBootcamp()
}

// Small Summary
/*
SnapShotFlow (COLD)
SnapshotFlow merupakan sideEffect Api yang digunakan untuk mengubah state flow yang diamati menjadi sebuah flow.
dari pengubahan tersebut hasil yang diamati dapat di proses dengan cara reaktif.
SnapshotFlow merupakan jembatan antara stateCompose dengan Flow

Kasus nyata yang bisa dijumpai
1. Mengamati formInput untuk validasi
2. Mengamati scroll view position

*/