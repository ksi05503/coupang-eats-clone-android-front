package com.example.risingtest.src.cart.models

import com.google.gson.annotations.SerializedName

data class PostAddMenuRequest(
    @SerializedName("cartId") val cartId: Int,
    @SerializedName("menuId") val menuId: Int,
    @SerializedName("menuCount") val menuCount: Int,
    @SerializedName("additionalMenuId") val additionalMenuId: Int
)
