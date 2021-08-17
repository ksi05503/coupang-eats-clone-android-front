package com.example.risingtest.src.main.franchises.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class FranchisesResponse(
    //3인방
    @SerializedName("result") val result : List<FranchisesResult>
):BaseResponse()
