package com.example.risingtest.src.main.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityLoginBinding
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.login.models.LoginResponse
import com.example.risingtest.src.main.login.models.PostLoginRequest

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) ,LoginActivityView{
    var userEmail:String =""
    var password:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "로그인"


        binding.apply {
            loginBtn.setOnClickListener {
                userEmail = editTextLoginEmail.text.toString()
                password = editTextLoginPassword.text.toString()
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

        val editor :SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()
        editor.putString("MY_EMAIL", userEmail)
        editor.putString("MY_PASSWORD", password)
        editor.putInt("MY_USERID", response.result.userId)
        editor.putString("MY_JWT", response.result.jwt)
        editor.putString("X-ACCESS-TOKEN", response.result.jwt)
        editor.apply()
        Log.d("SPSPSP", "$userEmail,$password")

 //       Log.d("SPSPSP", ApplicationClass.sSharedPreferences.getString("MY_JWT","")!!)

        //모든액티비티 없애고 메인액티비티 다시 띄움(즉 앱 재시작과 같다)
        val i = Intent(this, MainActivity::class.java)
        ActivityCompat.finishAffinity(this)
        startActivity(i)
    }

    override fun onPostLoginFailure(message: String) {
        Log.d("Okhttp", "실패 : $message")
    }
}
