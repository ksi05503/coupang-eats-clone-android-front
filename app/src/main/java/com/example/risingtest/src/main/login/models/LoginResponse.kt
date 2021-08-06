package com.example.risingtest.src.main.login.models

import com.example.risingtest.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    //3인방 포함
    @SerializedName("result") val result: LoginResult
): BaseResponse()
