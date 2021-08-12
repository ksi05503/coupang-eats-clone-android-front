package com.example.risingtest.src.cart.models

import com.google.gson.annotations.SerializedName

data class DetailMenuResponse(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : DetailMenuResult
)
