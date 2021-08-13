package com.example.risingtest.src.main.cart.models

import com.google.gson.annotations.SerializedName

data class RestMenuResult (
    @SerializedName("restId") val restId : Int,
    @SerializedName("menuId") val menuId : Int,
    @SerializedName("menuImageUrl") val menuImageUrl : String,
    @SerializedName("menuName") val menuName : String,
    @SerializedName("menuInfo") val menuInfo : String,
    @SerializedName("menuPrice") val menuPrice : Int
)