package com.example.risingtest.src.main.cart

import com.example.risingtest.config.BaseResponse
import com.example.risingtest.src.main.cart.models.DetailMenuResponse
import com.example.risingtest.src.main.cart.models.NewCartResponse
import com.example.risingtest.src.main.cart.models.PostAddMenuRequest
import com.example.risingtest.src.main.cart.models.PostNewCartsRequest
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

    @POST("/app/carts")
    fun postAddMenu(@Body params: PostAddMenuRequest): Call<BaseResponse>
}