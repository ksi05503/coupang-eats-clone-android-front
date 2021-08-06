package com.example.risingtest.src.main.login.models

import com.google.gson.annotations.SerializedName

data class LoginResult(
    @SerializedName("userId") val userId:Int,
    @SerializedName("jwt") val jwt: String
)
