package com.example.risingtest.src.main.favorites.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class GetBookmarksResponse(
    @SerializedName("result")val result:List<GetBookmarksResult>
):BaseResponse()
