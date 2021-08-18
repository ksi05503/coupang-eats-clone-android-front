package com.example.risingtest.src.main.orders.models

import com.google.gson.annotations.SerializedName

data class GetOrdersResult(
    @SerializedName("menuName") val menuName:String,
    @SerializedName("menuCount") val menuCount:String,
    @SerializedName("createdAt") val createdAt:String
)
