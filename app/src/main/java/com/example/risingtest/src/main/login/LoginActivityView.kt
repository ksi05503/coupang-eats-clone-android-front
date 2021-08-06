package com.example.risingtest.src.main.login

import com.example.risingtest.src.main.login.models.LoginResponse

interface LoginActivityView {
    fun onPostLoginSuccess(response: LoginResponse)

    fun onPostLoginFailure(message: String)
}