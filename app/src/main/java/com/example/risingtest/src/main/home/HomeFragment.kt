package com.example.risingtest.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.RestaurantProfileData
import com.example.risingtest.src.main.RestaurantType
import com.example.risingtest.src.main.home.models.CategoryResult
import com.example.risingtest.src.main.home.models.HomeResponse

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) ,HomeFragmentView    {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRestaurantFilterClickListener()


        if(checkIsLogin()){
            HomeService(this).tryGetHome(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0))
            Log.d("homeSPSPSP","현재 내 id:${ApplicationClass.sSharedPreferences.getInt("MY_USERID",0)}")

        }else{
            //비로그인시 어쩔랭
            Log.d("homeSPSPSP","비로그인상태")
            HomeService(this).tryGetHome(15)

        }





        val restaurantProfileAdapter = RestaurantProfileAdapter()
        restaurantProfileAdapter.dataSet = setRestaurantProfileDummyData()
        binding.recyclerViewFranchise.adapter = restaurantProfileAdapter

        val couponAdapter = CouponAdapter()
        couponAdapter.dataSet = setCouponDummyData()
        binding.recyclerViewCoupon.adapter = couponAdapter

        val restaurantNewProfileAdapter = RestaurantProfileAdapter()
        restaurantNewProfileAdapter.dataSet = setRestaurantNewProfileDummyData()
        binding.recyclerViewNewRestaurant.adapter = restaurantNewProfileAdapter

    }

    private fun initRestaurantFilterClickListener() {
        binding.apply{
            homeLayoutSortType.setOnClickListener {

            }
        }
    }


    private fun setRestaurantNewProfileDummyData(): MutableList<RestaurantProfileData> {
        var dataList = mutableListOf<RestaurantProfileData>()
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"피자헛 건대점","4.1","0","1.3km","2000원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_3,"공차 건대점","4.0","0","1.7km","3800원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"할매떡볶이 건대점","5.0","9","1.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"피자헛 건대점","4.1","0","1.3km","2000원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"피자헛 건대점","4.1","2","1.3km","2000원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"피자헛 건대점","4.1","0","1.3km","2000원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"피자헛 건대점","4.1","2","1.3km","2000원"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"피자헛 건대점","4.1","2","1.3km","2000원"))

        return dataList
    }

    private fun setCouponDummyData(): MutableList<Int> {
        var dataList = mutableListOf<Int>()
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        dataList.add(R.drawable.coupon1)
        return dataList
    }



    fun setRestaurantProfileDummyData(): MutableList<RestaurantProfileData>{
        var dataList = mutableListOf<RestaurantProfileData>()
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"버거킹 군자능동점","4.5","1394","0.9km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_3,"미친피자 건대본점","4.9","136","0.4km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"형제닭발 건대점","4.7","12","0.3km","무료배달"))
        return dataList

    }

    override fun onGetHomeSuccess(response: HomeResponse) {
        Log.d("Okhttp",response.message.toString())

        val restaurantTypeAdapter = RestaurantTypeAdapter()
        restaurantTypeAdapter.dataSet = response.result.categoryResult
        binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter

    }

    override fun onGetHomeFailure(message: String) {
        Log.d("Okhttp", "실패 : $message")
    }


}