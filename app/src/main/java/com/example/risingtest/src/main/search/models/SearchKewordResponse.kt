package com.example.risingtest.src.main.search.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SearchKewordResponse(
    @SerializedName("result") val result: List<SearchKewordResult>
) : BaseResponse()
