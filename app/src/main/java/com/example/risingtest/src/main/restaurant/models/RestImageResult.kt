package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class RestImageResult (

    @SerializedName("restId") val restId : Int,
    @SerializedName("restImageUrl") val restImageUrl : String
)