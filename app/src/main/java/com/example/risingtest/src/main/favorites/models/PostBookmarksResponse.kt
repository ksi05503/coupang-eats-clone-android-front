package com.example.risingtest.src.main.favorites.models

import com.google.gson.annotations.SerializedName

data class PostBookmarksResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null
)
