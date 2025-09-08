package com.putrapebrianonurba.kotlindevbootcamp.retrofit.model

data class Product(
    val id: Int,
    val title: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val thumbnail: String,
)

data class ProductResponse(
    val products: List<Product>
)
