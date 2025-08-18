package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwipeToDeleteBootcamp() {
    var list = remember { mutableStateListOf(SwipeToDelete(1, "Putra"), SwipeToDelete(2, "Pebriano"), SwipeToDelete(3, "Nurba")) }

    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items = list, key = { _, item -> item.id }) { index, item ->
            val state = rememberSwipeToDismissBoxState(
                confirmValueChange = { value ->
                    if (value == SwipeToDismissBoxValue.StartToEnd) {
                        list.remove(item)
                    }
                    true
                }
            )

            SwipeToDismissBox(
                state = state,
                backgroundContent =  {
                    val color = when (state.dismissDirection) {
                        SwipeToDismissBoxValue.StartToEnd -> Color.Red
                        SwipeToDismissBoxValue.EndToStart -> Color.Green
                        else -> Color.Transparent
                    }

                    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 6.dp).clip(RoundedCornerShape(10.dp)).background(color)){
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete", modifier = Modifier.align(Alignment.CenterEnd).padding(horizontal = 10.dp))
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit", modifier = Modifier.align(Alignment.CenterStart).padding(horizontal = 10.dp))
                    }
                }
            ) {
                RowSwipeToDelete(list = item)
            }
        }
    }
}

@Composable
private fun RowSwipeToDelete(list: SwipeToDelete) {
    Card(modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)) {
        Box(modifier = Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.Center) {
            Text(list.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }
    }
}

data class SwipeToDelete(val id: Int, val name: String)

@Preview(showBackground = true)
@Composable
fun SwipeToDeleteBootcampPreview() {
    SwipeToDeleteBootcamp()
}