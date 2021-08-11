package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class RestInfoResult(

    @SerializedName("restName") val restName : String,
    @SerializedName("star") val star : Double,
    @SerializedName("reviewCount") val reviewCount : Int,
    @SerializedName("distance_KM") val distance_KM : Int,
    @SerializedName("Cheetah") val Cheetah : String,
    @SerializedName("deliveryFee") val deliveryFee : String,
    @SerializedName("minimumAmount") val minimumAmount : String
)
