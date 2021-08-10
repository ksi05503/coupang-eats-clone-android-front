package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class CategoryResult (
    @SerializedName("categoryName") val categoryName : String,
    @SerializedName("categoryImageUrl") val categoryImageUrl : String
    )