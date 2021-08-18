package com.example.risingtest.src.main.restaurant.models

import com.google.gson.annotations.SerializedName

data class PostBookmarksRequest(
    @SerializedName("restId") val restId: Int

)
