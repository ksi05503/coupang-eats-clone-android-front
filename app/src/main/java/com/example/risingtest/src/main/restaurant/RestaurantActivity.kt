package com.example.risingtest.src.main.restaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityRestaurantBinding
import com.example.risingtest.src.main.favorites.FavoritesService
import com.example.risingtest.src.main.payment.PaymentActivity
import com.example.risingtest.src.main.restaurant.models.MenuResponse
import com.example.risingtest.src.main.restaurant.models.MenuResult
import com.example.risingtest.src.main.restaurant.models.PostBookmarksRequest
import com.example.risingtest.src.main.restaurant.models.PostBookmarksResponse

class RestaurantActivity : BaseActivity<ActivityRestaurantBinding>(ActivityRestaurantBinding::inflate),RestaurantActivityView {
    var restaurantActivitycartId = -1
    var isBookmark = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBtnClickListener()
        binding.btnShowCart.visibility = View.GONE
        //생성된카트가있다면
        if(intent.hasExtra("cartId")){
            //카트보기 버튼 띄우기
            binding.btnShowCart.visibility = View.VISIBLE
            binding.restaurantActivityBottomPrice.text = "${intent.getIntExtra("totalPrice",0)}원"
            //카트id 지정
            restaurantActivitycartId = intent.getIntExtra("cartId", -1)
            Log.d("Okhttp", "카트 존재하는상태 : $restaurantActivitycartId 번 카트")

        }else{

        }


        var restId = 1

        if(intent.hasExtra("restId")){
            restId = intent.getIntExtra("restId",1)
        }

        if(checkIsLogin()){
            RestaurantService(this).tryGetMenu(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0),restId)

        }else{
            RestaurantService(this).tryGetMenuNonLogin(restId)
        }
/*            val restaurantMenuAdapter = RestaurantMenuAdapter()
            restaurantMenuAdapter.dataSet = setRestaurantMenuDummyData()
            binding.recyclerViewRestaurantMenu.adapter = restaurantMenuAdapter*/


        var oneTimebookmark = 0
        binding.restaurantBookmarkFavoritesBtn.setOnClickListener {
            if(isBookmark ==0){
                binding.restaurantBookmarkFavoritesBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
                isBookmark = 1
                if(oneTimebookmark == 0){
                    oneTimebookmark = 1
                    // 북마크 api 호출
/*                    val postBookmarksRequest = PostBookmarksRequest(2)
                    RestaurantService(this).tryPostBookmarks(1,postBookmarksRequest)*/

                }
            }else{
                binding.restaurantBookmarkFavoritesBtn.setBackgroundResource(R.drawable.ic_baseline_favorite_border_a)
                isBookmark = 0
            }
        }
    }


    private fun initBtnClickListener() {
        binding.btnShowCart.setOnClickListener {
            //결제액티비티로 이동
            val i = Intent(this, PaymentActivity::class.java)
            i.putExtra("cartId", restaurantActivitycartId)
            startActivity(i)
        }
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
        restaurantMenuAdapter.restaurantActivityCartId = restaurantActivitycartId



        Log.d("Okhttp123123","myjwt:${ApplicationClass.sSharedPreferences.getString("MY_JWT", "")}")


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
        restaurantMenuAdapter.restaurantActivityCartId = restaurantActivitycartId
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

    override fun onPostBookmarksSuccess(response: PostBookmarksResponse) {
        showCustomToast("북마크성공")
    }

    override fun onPostBookmarksFailure(message: String) {

    }
}