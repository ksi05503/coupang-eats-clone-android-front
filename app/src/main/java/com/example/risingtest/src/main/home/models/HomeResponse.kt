package com.example.risingtest.src.main.home.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class HomeResponse(
    //3인방 추가
    @SerializedName("result") val result : List<List<HomeResult>>
): BaseResponse()
