package com.putrapebrianonurba.kotlindevbootcamp.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.model.Product
import com.putrapebrianonurba.kotlindevbootcamp.retrofit.remote.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init{
        fetchProducts()
    }
    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.getProducts()
                _products.value = response.products
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}