package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class MenuResponse (
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : Result
    )