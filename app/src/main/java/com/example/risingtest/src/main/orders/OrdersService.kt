package com.example.risingtest.src.main.orders

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.orders.models.GetOrdersResponse
import com.example.risingtest.src.main.payment.PaymentRetrofitInterface
import com.example.risingtest.src.main.payment.models.PaymentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrdersService(val view: OrdersFragmentView) {

    fun tryGetOrders(userId:Int){
        val ordersRetrofitInterface =
            ApplicationClass.sRetrofit.create(OrdersRetrofitInterface::class.java)

        ordersRetrofitInterface.getOrders(userId).enqueue(object :
            Callback<GetOrdersResponse> {
            override fun onResponse(call: Call<GetOrdersResponse>, response: Response<GetOrdersResponse>) {
                view.onGetOrdersSuccess(response.body() as GetOrdersResponse)
            }

            override fun onFailure(call: Call<GetOrdersResponse>, t: Throwable) {
                view.onGetOrdersFailure(t.message ?: "통신 오류")
            }

        }
        )

    }

}