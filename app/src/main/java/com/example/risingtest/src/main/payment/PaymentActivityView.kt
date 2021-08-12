package com.example.risingtest.src.main.payment

import com.example.risingtest.src.main.payment.models.PaymentResponse

interface PaymentActivityView {
    fun onGetPaymentSuccess(response: PaymentResponse)
    fun onGetPaymentFailure(message: String)


}