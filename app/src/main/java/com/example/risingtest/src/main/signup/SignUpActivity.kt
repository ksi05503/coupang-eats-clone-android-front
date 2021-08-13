package com.example.risingtest.src.main.signup

import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySignUpBinding
import com.example.risingtest.src.main.signup.models.PostSignUpRequest
import com.example.risingtest.src.main.signup.models.SignUpResponse

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(ActivitySignUpBinding::inflate), SignUpActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "회원가입"

        binding.apply {
            linearLayoutCheckParent.setOnClickListener {
                checkBox0.isChecked = true
                checkBox1.isChecked = true
                checkBox2.isChecked = true
                checkBox3.isChecked = true
                checkBox4.isChecked = true
                checkBox5.isChecked = true
            }


            signUpBtn.setOnClickListener {
                val userEmail = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                val phoneNumber = editTextPhone.text.toString()
                val userName = editTextName.text.toString()

                val postSignUpRequest = PostSignUpRequest(userEmail = userEmail, password = password, phoneNumber= phoneNumber, userName = userName)
                SignUpService(this@SignUpActivity).tryPostSignUp(postSignUpRequest)
            }

        }

    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        Log.d("Okhttp",response.message.toString())

        finish()
    }

    override fun onPostSignUpFailure(message: String) {
        Log.d("Okhttp", "실패 : $message")
    }


}