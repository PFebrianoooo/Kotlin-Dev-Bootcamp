package com.putrapebrianonurba.kotlindevbootcamp.retrofit.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.viewmodel.ProductsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color


@Composable
fun ProductsView(productsVM: ProductsViewModel = ProductsViewModel()) {
    val products by productsVM.products.collectAsState()
    val error by productsVM.error.collectAsState()

    when {
        error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Error loading products\npastikan anda memiliki koneksi internet")
            }
        }
        products.isEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Produk Kosong\nTambahkan produk baru untuk ditampilkan di sini")
            }
        }
        else -> {
            LazyColumn(
                modifier = Modifier
                    .background(Color.Black)
                    .statusBarsPadding()
                    .navigationBarsPadding()
            ) {
                items(products) { product ->
                    ProductCard(product)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsViewPreview() {
    ProductsView()
}
