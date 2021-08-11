package com.example.risingtest.src.main.restaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityRestaurantBinding
import com.example.risingtest.src.main.restaurant.models.MenuResponse
import com.example.risingtest.src.main.restaurant.models.MenuResult

class RestaurantActivity : BaseActivity<ActivityRestaurantBinding>(ActivityRestaurantBinding::inflate),RestaurantActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //지금 id 15번에 더미가 없어서 볼수가없다.
        if(checkIsLogin()){
            RestaurantService(this).tryGetMenu(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0),1)

        }else{
         //   RestaurantService(this).tryGetMenuNonLogin(1)


        }
/*            val restaurantMenuAdapter = RestaurantMenuAdapter()
            restaurantMenuAdapter.dataSet = setRestaurantMenuDummyData()
            binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter*/
    }

    private fun setRestaurantMenuDummyData(): List<MenuResult> {
        return listOf(
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보"),
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보"),
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보"),
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보"),
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보"),
            MenuResult(1, "1", "명품과일도시락", "3000원", "보류", "상세정보")
        )
    }

    override fun onGetMenuSuccess(response: MenuResponse) {
/*        Log.d("Okhttp123123",response.result.menuResult[0].menuName)
        Log.d("Okhttp123123",response.result.menuResult.size.toString())*/

        //식당 정보
        binding.apply {

        }



        //메뉴 리사이클러뷰
        val restaurantMenuAdapter = RestaurantMenuAdapter()
        restaurantMenuAdapter.dataSet = response.result.menuResult
        binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter


    }

    override fun onGetMenuFailure(message: String) {
    }

    override fun onGetMenuNonLoginSuccess(response: MenuResponse) {

        Log.d("IwantSleep",response.result.toString())
        //메뉴 리사이클러뷰
        val restaurantMenuAdapter = RestaurantMenuAdapter()
        restaurantMenuAdapter.dataSet = response.result.menuResult
        binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter

        //식당정보
        binding.apply{
            textMenuRestaurantName.text = response.result.restInfoResult[0].restName
            restStar.text = response.result.restInfoResult[0].star.toString()
            textMenuRestaurantReviewCount.text = "리뷰 ${response.result.restInfoResult[0].reviewCount}개"
            textMenuRestaurantDeliveryFee.text = response.result.restInfoResult[0].deliveryFee
            textMenuRestaurantLeastCost.text = response.result.restInfoResult[0].minimumAmount
        }
    }

    override fun onGetMenuNonLoginFailure(message: String) {
    }
}