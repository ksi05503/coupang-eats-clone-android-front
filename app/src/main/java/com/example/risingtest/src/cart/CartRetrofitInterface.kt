package com.example.risingtest.src.cart

import com.example.risingtest.src.cart.models.NewCartResponse
import com.example.risingtest.src.cart.models.PostNewCartsRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CartRetrofitInterface {
    @POST("/app/newCarts")
    fun postNewCart(@Body params: PostNewCartsRequest): Call<NewCartResponse>
}