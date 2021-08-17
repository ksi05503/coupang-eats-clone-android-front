package com.example.risingtest.src.main.search.models

import com.google.gson.annotations.SerializedName

data class GetSearchContentRequest(
    @SerializedName("searchContent") val searchContent : String
)
