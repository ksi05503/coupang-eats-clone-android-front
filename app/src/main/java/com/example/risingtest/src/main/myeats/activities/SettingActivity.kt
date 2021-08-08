package com.example.risingtest.src.main.myeats.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySettingBinding
import com.example.risingtest.src.main.MainActivity

class SettingActivity : BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.logoutBtnSetting.setOnClickListener {
            val editor:SharedPreferences.Editor = ApplicationClass.sSharedPreferences.edit()
            editor.clear()
            editor.apply()
            Log.d("SPSPSP","로그아웃완료")

            
            //모든액티비티 없애고 메인액티비티 다시 띄움(즉 앱 재시작과 같다)
            val i = Intent(this,MainActivity::class.java)
            ActivityCompat.finishAffinity(this)
            startActivity(i)

        }
    }

}