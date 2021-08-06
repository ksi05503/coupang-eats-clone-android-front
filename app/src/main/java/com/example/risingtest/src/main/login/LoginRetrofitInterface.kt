package com.example.risingtest.src.main.login

import com.example.risingtest.src.main.login.models.LoginResponse
import com.example.risingtest.src.main.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/app/logins")
    fun postSignUp(@Body params: PostLoginRequest): Call<LoginResponse>
}