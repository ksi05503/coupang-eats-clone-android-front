package com.example.risingtest.src.main.signup

import com.example.risingtest.src.main.signup.models.PostSignUpRequest
import com.example.risingtest.src.main.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitInterface {
    @POST("/app/users")
    fun postSignUp(@Body params : PostSignUpRequest) : Call<SignUpResponse>
}