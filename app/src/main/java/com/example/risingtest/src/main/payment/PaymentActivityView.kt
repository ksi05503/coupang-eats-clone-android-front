package com.example.risingtest.src.main.payment

import com.example.risingtest.src.main.payment.models.PaymentResponse
import com.example.risingtest.src.main.payment.models.PostOrderResponse

interface PaymentActivityView {
    fun onGetPaymentSuccess(response: PaymentResponse)
    fun onGetPaymentFailure(message: String)

    fun onPostOrderSuccess(response: PostOrderResponse)
    fun onPostOrderFailure(message: String)


}