package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class HomeResult(

    @SerializedName("homeUserAddressResult") val homeUserAddressResult : List<HomeUserAddressResult>,
    @SerializedName("eventResult") val eventResult : List<EventResult>,
    @SerializedName("categoryResult") val categoryResult : List<CategoryResult>,
    @SerializedName("homeRestResult") val homeRestResult : List<List<HomeRestResult>>
)
