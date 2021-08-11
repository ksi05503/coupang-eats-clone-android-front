package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class ReviewResult (

    @SerializedName("reviewId") val reviewId : Int,
    @SerializedName("reviewImageUrl") val reviewImageUrl : String,
    @SerializedName("reviewContent") val reviewContent : String,
    @SerializedName("star") val star : Double
)