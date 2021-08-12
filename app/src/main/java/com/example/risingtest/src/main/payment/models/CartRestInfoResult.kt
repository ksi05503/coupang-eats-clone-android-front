package com.example.risingtest.src.main.payment.models

import com.google.gson.annotations.SerializedName

data class CartRestInfoResult(
    @SerializedName("restName") val restName : String,
    @SerializedName("Cheetah") val cheetah : String
)
