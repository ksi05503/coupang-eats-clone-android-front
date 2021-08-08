package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeResult(

    @SerializedName("userId") val userId : Int,
    @SerializedName("defaultAddressId") val defaultAddressId : Int,
    @SerializedName("homeAddress") val homeAddress : String,
    @SerializedName("eupMyeonDongCode") val eupMyeonDongCode : Int,
    @SerializedName("userLatitue") val userLatitue : Double,
    @SerializedName("userHardness") val userHardness : Double
)
