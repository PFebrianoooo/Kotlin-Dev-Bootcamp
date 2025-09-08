package com.putrapebrianonurba.kotlindevbootcamp.retrofit.remote

import com.putrapebrianonurba.kotlindevbootcamp.retrofit.model.ProductResponse
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}