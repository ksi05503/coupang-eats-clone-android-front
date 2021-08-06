package com.example.risingtest.src.main.signup.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(

    @SerializedName("userEmail") val userEmail: String,
    @SerializedName("password") val password: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("userName") val userName: String

)
