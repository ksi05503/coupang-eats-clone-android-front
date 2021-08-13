package com.example.risingtest.src.main.cart.models

import com.google.gson.annotations.SerializedName

data class PostNewCartsRequest(
    @SerializedName("userId") val userEmail: Int,
    @SerializedName("restId") val restId: Int
)
