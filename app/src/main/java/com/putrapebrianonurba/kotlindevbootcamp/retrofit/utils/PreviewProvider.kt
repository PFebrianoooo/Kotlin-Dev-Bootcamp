package com.putrapebrianonurba.kotlindevbootcamp.retrofit.utils

import com.putrapebrianonurba.kotlindevbootcamp.retrofit.model.Product

object PreviewProvider {
    val singleProduct = Product(
        id = 1,
        title = "Essence Mascara Lash Princess",
        category = "beauty",
        price = 10.99,
        discountPercentage = 12.99,
        thumbnail = "https://cdn.dummyjson.com/product-images/beauty/essence-mascara-lash-princess/thumbnail.webp"
    )
}