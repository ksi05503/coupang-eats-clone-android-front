package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("restImageResult") val restImageResult : List<RestImageResult>,
    @SerializedName("restInfoResult") val restInfoResult : List<RestInfoResult>,
    @SerializedName("reviewResult") val reviewResult : List<ReviewResult>,
    @SerializedName("menuResult") val menuResult : List<MenuResult>
)