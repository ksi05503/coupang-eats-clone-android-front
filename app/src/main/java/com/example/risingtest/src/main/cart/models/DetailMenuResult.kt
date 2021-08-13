package com.example.risingtest.src.main.cart.models

import com.google.gson.annotations.SerializedName

data class DetailMenuResult(
    @SerializedName("RestMenuResult") val restMenuResult : List<RestMenuResult>,
    @SerializedName("RestAdditionalMenuResult") val restAdditionalMenuResult : List<RestAdditionalMenuResult>
)
