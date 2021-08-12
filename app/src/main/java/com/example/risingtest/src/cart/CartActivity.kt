package com.example.risingtest.src.cart

import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityCartBinding
import com.example.risingtest.src.cart.models.NewCartResponse
import com.example.risingtest.src.cart.models.PostNewCartsRequest

class CartActivity : BaseActivity<ActivityCartBinding>(ActivityCartBinding::inflate),CartActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val postNewCartsRequest= PostNewCartsRequest(ApplicationClass.sSharedPreferences.getInt("MY_USERID",0),1)
        CartService(this).tryPostNewCart(postNewCartsRequest)

    }

    override fun onPostNewCartSuccess(response: NewCartResponse) {
        Log.d("Okhttp","성공: ${response.result.cartIdResult}번 카트")

    }

    override fun onPostNewCartFailure(message: String) {
        Log.d("Okhttp",message)
    }
}