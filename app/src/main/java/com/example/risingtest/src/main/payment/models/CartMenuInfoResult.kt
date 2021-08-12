package com.example.risingtest.src.main.payment.models

import com.google.gson.annotations.SerializedName

data class CartMenuInfoResult(
    @SerializedName("menuId") val menuId : Int,
    @SerializedName("menuName") val menuName : String,
    @SerializedName("totalAdditionalMenuContents") val totalAdditionalMenuContents : String,
    @SerializedName("totalPricePerMenu") val totalPricePerMenu : String
)