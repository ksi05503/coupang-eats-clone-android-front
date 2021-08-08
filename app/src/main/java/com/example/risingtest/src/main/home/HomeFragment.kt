package com.example.risingtest.src.main.home

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.RestaurantProfileData
import com.example.risingtest.src.main.RestaurantType

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home)    {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val restaurantTypeAdapter = RestaurantTypeAdapter()
        restaurantTypeAdapter.dataSet = setRestaurantTypeDummyData()
        binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter

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

    fun setRestaurantTypeDummyData(): MutableList<RestaurantType>{
        var dataList =  mutableListOf<RestaurantType>()

        dataList.add(RestaurantType(R.drawable.round_png_type1,"신규 맛집"))
        dataList.add(RestaurantType(R.drawable.round_png_type2,"1인분"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))

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


}