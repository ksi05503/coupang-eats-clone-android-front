package com.example.risingtest.src.main.signup.models

import com.google.gson.annotations.SerializedName

class SignUpResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null
)