package com.example.risingtest.src.main.login

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.login.models.LoginResponse
import com.example.risingtest.src.main.login.models.PostLoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService(val view: LoginActivityView) {
    fun tryPostLogin(postLoginRequest: PostLoginRequest){
        val loginRetrofitInterface = ApplicationClass.sRetrofit.create(LoginRetrofitInterface::class.java)
        loginRetrofitInterface.postSignUp(postLoginRequest).enqueue(object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                view.onPostLoginSuccess(response.body() as LoginResponse)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                view.onPostLoginFailure(t.message ?: "통신 오류")
            }
        })
    }
}