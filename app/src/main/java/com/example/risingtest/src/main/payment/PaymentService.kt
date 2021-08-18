package com.example.risingtest.src.main.payment

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.payment.models.PaymentResponse
import com.example.risingtest.src.main.payment.models.PostOrderRequest
import com.example.risingtest.src.main.payment.models.PostOrderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentService(val view: PaymentActivityView) {

    fun tryGetPayment(cartId:Int){
        val paymentRetrofitInterface =
            ApplicationClass.sRetrofit.create(PaymentRetrofitInterface::class.java)

        paymentRetrofitInterface.getPayment(cartId = cartId).enqueue(object :
            Callback<PaymentResponse> {
            override fun onResponse(call: Call<PaymentResponse>, response: Response<PaymentResponse>) {
                view.onGetPaymentSuccess(response.body() as PaymentResponse)
            }

            override fun onFailure(call: Call<PaymentResponse>, t: Throwable) {
                view.onGetPaymentFailure(t.message ?: "통신 오류")
            }

        }
        )

    }

    fun tryPostOrder(cartId:Int, reqManager:String, reqDelivery:String , disposableCheck:String){
        val paymentRetrofitInterface =
            ApplicationClass.sRetrofit.create(PaymentRetrofitInterface::class.java)
        val postOrderRequest = PostOrderRequest(cartId, reqManager, reqDelivery, disposableCheck)
        paymentRetrofitInterface.postOrder(postOrderRequest).enqueue(object :
            Callback<PostOrderResponse> {
            override fun onResponse(call: Call<PostOrderResponse>, response: Response<PostOrderResponse>) {
                view.onPostOrderSuccess(response.body() as PostOrderResponse)
            }

            override fun onFailure(call: Call<PostOrderResponse>, t: Throwable) {
                view.onPostOrderFailure(t.message ?: "통신 오류")
            }

        }
        )

    }

}