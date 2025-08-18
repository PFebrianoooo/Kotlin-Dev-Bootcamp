package com.putrapebrianonurba.kotlindevbootcamp

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyGridBootcamp() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item(span = { GridItemSpan(3)}) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth().height(400.dp).background(Color.Gray)) {
                Text("Profile Information",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

        }
        items(count = 100) { item ->
            Box(
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Item $item")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyGridBootcampPreview() {
    LazyGridBootcamp()
}

// Small Summary
/*
Lazy Grid
Lazy Grid merupakan sebuah fitur yang terdapat pada jetpack compose yang mana membuat sebuah kotak kotak yang
dapat di scroll kebawah atau kesamping. Di sebut lazu di karenakan konten yang muncul akan dimuat ketika tampil di layar
Konsepnya sama dengan lazy lazy sebelumnya.

Struktur dasar
> Lazy Vertical Grid
LazyVerticalGrid(param) {
    Args
}

> Lazy Horizontal Grid
LazyHorizontalGrid(param) {
    Args
}

Param grid ada apa saja?
Rows/columns: GridCells,
modifier: Modifier = Modifier,
state: LazyGridState = rememberLazyGridState(),
contentPadding: PaddingValues = PaddingValues(0.dp),
reverseLayout: Boolean = false,
verticalArrangement: Arrangement.Vertical
horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
userScrollEnabled: Boolean = true,
content: LazyGridScope.() -> Unit
)
*/
