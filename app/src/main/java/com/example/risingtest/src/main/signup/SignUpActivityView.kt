package com.example.risingtest.src.main.signup

import com.example.risingtest.src.main.signup.models.SignUpResponse

interface SignUpActivityView {
    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}