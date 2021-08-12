package com.example.risingtest.src.main.payment

import com.example.risingtest.src.main.payment.models.PaymentResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PaymentRetrofitInterface {

    @GET ("/app/carts/{cartId}")
    fun getPayment(@Path("cartId")cartId:Int) : Call<PaymentResponse>

}