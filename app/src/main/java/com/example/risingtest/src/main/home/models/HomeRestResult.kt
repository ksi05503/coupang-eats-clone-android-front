package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeRestResult(
    @SerializedName("restId") val restId : Int,
    @SerializedName("userId") val userId : Int,
    @SerializedName("restName") val restName : String,
    @SerializedName("repRestImageUrl") val repRestImageUrl : String,
    @SerializedName("restIcon") val restIcon : String,
    @SerializedName("deliveryFee") val deliveryFee : String,
    @SerializedName("star") val star : Double,
    @SerializedName("count(reviewId)") val count_review : Int,
    @SerializedName("distance_KM") val distance_KM : Double
)
