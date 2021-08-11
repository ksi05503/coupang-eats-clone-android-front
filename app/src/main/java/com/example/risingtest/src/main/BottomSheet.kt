package com.example.risingtest.src.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.risingtest.R
import com.example.risingtest.src.main.login.LoginActivity
import com.example.risingtest.src.main.signup.SignUpActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet(version: Int)  : BottomSheetDialogFragment() {

    // 0: 로그인
    // 1: 배달비
    // 2: 최소주문금액
    val version = version
    //  lateinit var binding: DialogBottomLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return if(version==0){
            inflater.inflate(R.layout.dialog_bottom_login, container, false)
        }else if(version ==1){
            inflater.inflate(R.layout.dialog_bottom_delivery_fee, container, false)
        }else if(version ==2){
            inflater.inflate(R.layout.dialog_bottom_least_cost, container, false)
        }else{
            inflater.inflate(R.layout.dialog_bottom_login, container, false)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view?.findViewById<Button>(R.id.dialog_bottom_btn_id_login)?.setOnClickListener {
            val i = Intent(view?.context, LoginActivity::class.java )
            startActivity(i)
            dismiss()
        }

        view?.findViewById<TextView>(R.id.dialog_bottom_btn_sign_up)?.setOnClickListener {
            val i = Intent(view?.context, SignUpActivity::class.java)
            startActivity(i)
            dismiss()

        }
    }

}