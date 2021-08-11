package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class MenuResult(

    @SerializedName("menuId") val menuId : Int,
    @SerializedName("subMenuCategory") val subMenuCategory : String,
    @SerializedName("menuName") val menuName : String,
    @SerializedName("menuprice") val menuprice : String,
    @SerializedName("menuImageUrl") val menuImageUrl : String,
    @SerializedName("menuInfo") val menuInfo : String
)
