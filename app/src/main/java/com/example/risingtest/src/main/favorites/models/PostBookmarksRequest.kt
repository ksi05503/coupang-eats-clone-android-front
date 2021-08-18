package com.example.risingtest.src.main.favorites.models

import com.google.gson.annotations.SerializedName

data class PostBookmarksRequest(
    @SerializedName("restId") val restId: Int

)
