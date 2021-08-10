package com.example.risingtest.src.main.home.models

import com.google.gson.annotations.SerializedName

data class EventResult (
    @SerializedName("eventImageUrl") val eventImageUrl : String,
    @SerializedName("connectUrl") val connectUrl : String
)