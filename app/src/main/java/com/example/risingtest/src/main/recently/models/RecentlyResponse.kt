package com.example.risingtest.src.main.recently.models

import com.example.risingtest.config.BaseResponse
import com.example.risingtest.src.main.franchises.models.FranchisesResult
import com.google.gson.annotations.SerializedName

data class RecentlyResponse(
    //3인방
    @SerializedName("result") val result : List<RecentlyResult>
): BaseResponse()
