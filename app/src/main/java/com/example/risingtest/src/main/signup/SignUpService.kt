package com.example.risingtest.src.main.signup

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.signup.models.PostSignUpRequest
import com.example.risingtest.src.main.signup.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService(val view: SignUpActivityView) {

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest) {
        val signUpRetrofitInterface =
            ApplicationClass.sRetrofit.create(SignUpRetrofitInterface::class.java)
            signUpRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object:
            Callback<SignUpResponse>{
                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    view.onPostSignUpSuccess(response.body() as SignUpResponse)
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    view.onPostSignUpFailure(t.message ?: "통신 오류")
                }

            }

            )


    }

}

