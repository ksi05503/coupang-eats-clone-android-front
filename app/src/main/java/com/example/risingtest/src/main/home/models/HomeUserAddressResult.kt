package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeUserAddressResult (
    @SerializedName("userId") val userId : Int,
    @SerializedName("defaultAddressId") val defaultAddressId : Int,
    @SerializedName("homeAddress") val homeAddress : String,
    @SerializedName("eupMyeonDongCode") val eupMyeonDongCode : Int,
    @SerializedName("userLatitude") val userLatitude : Double,
    @SerializedName("userLongitude") val userLongitude : Double
)