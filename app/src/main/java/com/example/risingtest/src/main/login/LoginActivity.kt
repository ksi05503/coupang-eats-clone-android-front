package com.example.risingtest.src.main.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityLoginBinding
import com.example.risingtest.src.main.login.models.LoginResponse
import com.example.risingtest.src.main.login.models.PostLoginRequest

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) ,LoginActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "로그인"


        binding.apply {
            loginBtn.setOnClickListener {
                val userEmail = editTextLoginEmail.text.toString()
                val password = editTextLoginPassword.text.toString()
/*
                val userEmail = "yeon@naver.com"
                val password = "11111111"
*/

                val postLoginRequest = PostLoginRequest(userEmail = userEmail, password = password)
                showLoadingDialog(this@LoginActivity)
                LoginService(this@LoginActivity).tryPostLogin(postLoginRequest)

            }
        }


    }

    override fun onPostLoginSuccess(response: LoginResponse) {
        dismissLoadingDialog()
        Log.d("Okhttp",response.message.toString())
        Log.d("Okhttp","jwt: ${response.result.jwt}")
    }

    override fun onPostLoginFailure(message: String) {
        Log.d("Okhttp", "실패 : $message")
    }
}
