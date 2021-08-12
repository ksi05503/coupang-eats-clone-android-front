package com.example.risingtest.src.cart

import com.example.risingtest.src.cart.models.DetailMenuResponse
import com.example.risingtest.src.cart.models.NewCartResponse
import com.example.risingtest.src.cart.models.PostNewCartsRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CartRetrofitInterface {
    @POST("/app/newCarts")
    fun postNewCart(@Body params: PostNewCartsRequest): Call<NewCartResponse>

    @GET("/app/restaurants/menu/{menuId}")
    fun getDetailMenu(@Path("menuId")menuId:Int) :Call<DetailMenuResponse>
}