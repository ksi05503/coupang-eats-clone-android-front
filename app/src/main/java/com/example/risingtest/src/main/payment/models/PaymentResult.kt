package com.example.risingtest.src.main.payment.models

import com.google.gson.annotations.SerializedName

data class PaymentResult(
    @SerializedName("cartAddressResult") val cartAddressResult : List<CartAddressResult>,
    @SerializedName("cartRestInfoResult") val cartRestInfoResult : List<CartRestInfoResult>,
    @SerializedName("cartMenuINfoResult") val cartMenuINfoResult : List<CartMenuInfoResult>,
    @SerializedName("cartDeliveryFeeResult") val cartDeliveryFeeResult : List<CartDeliveryFeeResult>,
    @SerializedName("cartPayMethodResult") val cartPayMethodResult : CartPayMethodResult
)
