package com.example.risingtest.src.main.myeats

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentMyEatsBinding
import com.example.risingtest.src.main.myeats.activities.SettingActivity

class MyEatsFragment :
    BaseFragment<FragmentMyEatsBinding>(FragmentMyEatsBinding::bind, R.layout.fragment_my_eats) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBtnClickListener()
    }

    private fun setBtnClickListener() {
        binding.apply {
            moveSettingBtnMyEats.setOnClickListener {
                val i= Intent(activity, SettingActivity::class.java)
                startActivity(i)
            }
        }
    }


}