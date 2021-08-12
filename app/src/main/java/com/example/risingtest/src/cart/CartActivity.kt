package com.example.risingtest.src.cart

import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityCartBinding
import com.example.risingtest.src.cart.models.DetailMenuResponse
import com.example.risingtest.src.cart.models.NewCartResponse
import com.example.risingtest.src.cart.models.PostNewCartsRequest

class CartActivity : BaseActivity<ActivityCartBinding>(ActivityCartBinding::inflate),CartActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CartService(this).tryGetDetailMenu(1)


        if(checkIsLogin()){
            //카트생성한채로 메뉴 구경
            val postNewCartsRequest= PostNewCartsRequest(ApplicationClass.sSharedPreferences.getInt("MY_USERID",0),1)
            CartService(this).tryPostNewCart(postNewCartsRequest)

        }else{
            //비로그인은 세부메뉴창에들어와도 카트생성API를 사용하지 않음 (조회만하는거)
        }



    }

    override fun onPostNewCartSuccess(response: NewCartResponse) {
        Log.d("Okhttp","카트생성 성공: ${response.result.cartIdResult}번 카트")

    }

    override fun onPostNewCartFailure(message: String) {
        Log.d("Okhttp",message)
    }

    override fun onGetDetailMenuSuccess(response: DetailMenuResponse) {
        Log.d("Okhttp","detail메뉴 성공: ${response.result.restAdditionalMenuResult.size}개의 세부메뉴")

        val detailMenuAdapter = DetailMenuAdapter()
        detailMenuAdapter.dataSet = response.result.restAdditionalMenuResult
        binding.recyclerViewDetailMenu.adapter = detailMenuAdapter

    }

    override fun onGetDetailMenuFailure(message: String) {
        Log.d("Okhttp",message)
    }
}