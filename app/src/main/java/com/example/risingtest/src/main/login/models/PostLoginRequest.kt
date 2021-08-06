package com.example.risingtest.src.main.login.models

import com.google.gson.annotations.SerializedName

data class PostLoginRequest (
    @SerializedName("userEmail") val userEmail: String,
    @SerializedName("password") val password: String
)