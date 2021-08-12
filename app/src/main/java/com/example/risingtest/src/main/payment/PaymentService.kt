package com.example.risingtest.src.main.payment

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.payment.models.PaymentResponse
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

}