package com.example.risingtest.src.main.payment.models

import com.google.gson.annotations.SerializedName

data class PostOrderRequest(
    @SerializedName("cartID")val cartId:Int,
    @SerializedName("reqManager")val reqManager:String,
    @SerializedName("reqDelivery")val reqDelivery:String,
    @SerializedName("disposableCheck")val disposableCheck:String
)
