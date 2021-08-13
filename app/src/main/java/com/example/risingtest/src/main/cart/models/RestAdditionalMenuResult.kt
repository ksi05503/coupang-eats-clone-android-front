package com.example.risingtest.src.main.cart.models

import com.google.gson.annotations.SerializedName

data class RestAdditionalMenuResult(
    @SerializedName("additionalMenuCategory") val additionalMenuCategory : String,
    @SerializedName("additionalMenuContents") val additionalMenuContents : String,
    @SerializedName("additionalMenuPrice") val additionalMenuPrice : Int,
    @SerializedName("additionalMenuId") val additionalMenuId : Int

)
