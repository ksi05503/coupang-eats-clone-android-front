package com.example.risingtest.src.main.search.models

import com.google.gson.annotations.SerializedName

data class SearchKewordResult(
    @SerializedName("searchContent")val searchContent:String,
    @SerializedName("date")val date:String
)
