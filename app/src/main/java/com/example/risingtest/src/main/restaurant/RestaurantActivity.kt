package com.example.risingtest.src.main.restaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityRestaurantBinding
import com.example.risingtest.src.main.restaurant.models.MenuResponse
import com.example.risingtest.src.main.restaurant.models.MenuResult

class RestaurantActivity : BaseActivity<ActivityRestaurantBinding>(ActivityRestaurantBinding::inflate),RestaurantActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var restId = 1

        if(intent.hasExtra("restId")){
            restId = intent.getIntExtra("restId",1)
        }

        //지금 id 15번에 더미가 없어서 볼수가없다.
        if(checkIsLogin()){
            RestaurantService(this).tryGetMenu(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0),restId)

        }else{
            RestaurantService(this).tryGetMenuNonLogin(restId)
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
        Log.d("Okhttp123123",response.result.menuResult[0].menuName)
        Log.d("Okhttp123123",response.result.menuResult.size.toString())

        //식당 정보
        binding.apply {
            Glide.with(menuRestaurantMainImage.context)
                .load(response.result.restImageResult[0].restImageUrl)
                .into(menuRestaurantMainImage)

            textMenuRestaurantName.text = response.result.restInfoResult[0].restName
            restStar.text = response.result.restInfoResult[0].star.toString()
            textMenuRestaurantReviewCount.text = "리뷰 ${response.result.restInfoResult[0].reviewCount}개"
            if(response.result.restInfoResult[0].deliveryFee =="무료") {
                textMenuRestaurantDeliveryFee.text = "무료배달"
            }else{
                textMenuRestaurantDeliveryFee.text = response.result.restInfoResult[0].deliveryFee

            }
            textMenuRestaurantLeastCost.text = response.result.restInfoResult[0].minimumAmount
        }



        //메뉴 리사이클러뷰
        val restaurantMenuAdapter = RestaurantMenuAdapter()
        restaurantMenuAdapter.dataSet = response.result.menuResult
        binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter


    }

    override fun onGetMenuFailure(message: String) {
        Log.d("Okhttp123123",message)
        Log.d("Okhttp123123","myjwt:${ApplicationClass.sSharedPreferences.getString("MY_JWT", "")}")
    }

    override fun onGetMenuNonLoginSuccess(response: MenuResponse) {

        Log.d("IwantSleep",response.result.toString())
        //메뉴 리사이클러뷰
        val restaurantMenuAdapter = RestaurantMenuAdapter()
        restaurantMenuAdapter.dataSet = response.result.menuResult
        binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter

        //식당정보
        binding.apply{
            Glide.with(menuRestaurantMainImage.context)
                .load(response.result.restImageResult[0].restImageUrl)
                .into(menuRestaurantMainImage)

            textMenuRestaurantName.text = response.result.restInfoResult[0].restName
            restStar.text = response.result.restInfoResult[0].star.toString()
            textMenuRestaurantReviewCount.text = "리뷰 ${response.result.restInfoResult[0].reviewCount}개"
            if(response.result.restInfoResult[0].deliveryFee =="무료") {
                textMenuRestaurantDeliveryFee.text = "무료배달"
            }else{
                textMenuRestaurantDeliveryFee.text = response.result.restInfoResult[0].deliveryFee

            }

            textMenuRestaurantLeastCost.text = response.result.restInfoResult[0].minimumAmount
        }

        Log.d("APIAPIAPI","최소주문: ${response.result.restInfoResult[0].minimumAmount}")
    }

    override fun onGetMenuNonLoginFailure(message: String) {
    }
}