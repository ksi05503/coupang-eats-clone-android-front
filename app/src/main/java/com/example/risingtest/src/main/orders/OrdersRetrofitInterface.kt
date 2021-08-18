package com.example.risingtest.src.main.orders

import com.example.risingtest.src.main.orders.models.GetOrdersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersRetrofitInterface {

    @GET("/app/users/{userId}/order-lists")
    fun getOrders(@Path("userId")userId: Int) : Call<GetOrdersResponse>
}