package com.example.risingtest.src.main.orders.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class GetOrdersResponse(
    @SerializedName("result") val result : List<GetOrdersResult>
): BaseResponse()
