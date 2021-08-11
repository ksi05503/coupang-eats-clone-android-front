package com.example.risingtest.src.main.home

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.BottomSheet
import com.example.risingtest.src.main.MainActivity
import com.example.risingtest.src.main.RestaurantProfileData
import com.example.risingtest.src.main.RestaurantType
import com.example.risingtest.src.main.home.models.CategoryResult
import com.example.risingtest.src.main.home.models.HomeResponse
import com.example.risingtest.src.main.home.models.HomeRestResult

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) ,HomeFragmentView    {

    private val filterArray = arrayOf(false,false,false,false,false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRestaurantFilterClickListener()

/*

        if(checkIsLogin()){
            HomeService(this).tryGetHome(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0))
            Log.d("homeSPSPSP","현재 내 id:${ApplicationClass.sSharedPreferences.getInt("MY_USERID",0)}")

        }else{
            //비로그인시 어쩔랭
            Log.d("homeSPSPSP","비로그인상태")
            HomeService(this).tryGetHome(15)

        }

*/
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

        val restaurantFamousAdapter = RestaurantFamousAdapter()
        restaurantFamousAdapter.dataSet = setRestaurantFamousDummyData()
        binding.recyclerViewFamousRestaurant.adapter = restaurantFamousAdapter

    }

    private fun setRestaurantFamousDummyData(): List<HomeRestResult> {
        val data = listOf<HomeRestResult>(
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"카츠곳간 킨텍스점","modify later","modify later","1000",4.9,14,1.1)
        )
        return data
    }


    private fun initRestaurantFilterClickListener() {
        binding.apply{


            val white_int = Color.parseColor("#FFFFFFFF")
            val lightblue_int = Color.parseColor("#00A6FF")
            val black_int = Color.parseColor("#FF000000")

            homeLayoutSortType.setOnClickListener {  //filterArray[0]
            }
            homeLayoutCheetah.setOnClickListener {  //filterArray[1]
                if(filterArray[1] == false){
                    homeLayoutCheetah.setBackgroundResource(R.drawable.border_shape_selected)
                    homeTextCheetah.setTextColor(white_int)
                }else{
                    homeLayoutCheetah.setBackgroundResource(R.drawable.border_shape_2)
                    homeTextCheetah.setTextColor(black_int)
                }
                filterArray[1] = !filterArray[1]
            }
            homeLayoutCharge.setOnClickListener {

                val bottomSheet= BottomSheet(1)
                bottomSheet.show(fragmentManager!!, bottomSheet.tag)

            }
            homeLayoutLeastCost.setOnClickListener {
                val bottomSheet = BottomSheet(2)
                bottomSheet.show(fragmentManager!!, bottomSheet.tag)
            }
            homeLayoutCoupon.setOnClickListener {
                if(filterArray[4] == false){
                    homeLayoutCoupon.setBackgroundResource(R.drawable.border_shape_selected)
                    homeTextCoupon.setTextColor(white_int)
                }else{
                    homeLayoutCoupon.setBackgroundResource(R.drawable.border_shape_2)
                    homeTextCoupon.setTextColor(black_int)
                }
                filterArray[4] = !filterArray[4]
            }
        }
    }

    private fun setRestaurantTypeDummyData(): List<CategoryResult> {
        var dataList = listOf<CategoryResult>(
            CategoryResult("1인분","a"),
            CategoryResult("한식","a"),
            CategoryResult("한식","a"),
            CategoryResult("한식","a")    )

        return dataList

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