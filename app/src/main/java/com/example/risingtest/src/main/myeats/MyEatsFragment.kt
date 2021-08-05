package com.example.risingtest.src.main.myeats

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentMyEatsBinding

class MyEatsFragment :
    BaseFragment<FragmentMyEatsBinding>(FragmentMyEatsBinding::bind, R.layout.fragment_my_eats) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}