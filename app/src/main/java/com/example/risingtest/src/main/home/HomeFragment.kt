package com.example.risingtest.src.main.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.cart.CartActivity
import com.example.risingtest.src.main.BottomSheet
import com.example.risingtest.src.main.franchises.FranchisesActivity
import com.example.risingtest.src.main.home.models.CategoryResult
import com.example.risingtest.src.main.home.models.HomeResponse
import com.example.risingtest.src.main.home.models.HomeRestResult
import com.example.risingtest.src.main.recently.RecentlyActivity
import com.example.risingtest.src.main.search.SearchActivity

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) ,HomeFragmentView    {
    var famousExtraListNonCheetah = mutableListOf<HomeRestResult>()
    var famousExtraListCheetah = mutableListOf<HomeRestResult>()

    val restaurantFamousAdapter = RestaurantFamousAdapter()

    private val filterArray = arrayOf(false,false,false,false,false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRestaurantFilterClickListener()

        binding.homeSearchBtn.setOnClickListener {
            val i =Intent(view.context , SearchActivity::class.java)
            startActivity(i)
        }
        binding.homeBtnToFranchises.setOnClickListener {
            val i = Intent(view.context, FranchisesActivity::class.java)
            startActivity(i)
        }
        binding.homeBtnToRecently.setOnClickListener {
            val i = Intent(view.context, RecentlyActivity::class.java)
            startActivity(i)
        }


        if(checkIsLogin()){
            HomeService(this).tryGetHome(ApplicationClass.sSharedPreferences.getInt("MY_USERID", 0))
            Log.d("homeSPSPSP","?????? ??? id:${ApplicationClass.sSharedPreferences.getInt("MY_USERID",0)}")

        }else{
            //??????????????? ?????????

            HomeService(this).tryGetHomeNonLogin()
            Log.d("homeSPSPSP","??????????????????")



/*
            Log.d("homeSPSPSP","??????????????????")
            HomeService(this).tryGetHome(15)
*/

/*            val restaurantTypeAdapter = RestaurantTypeAdapter()
            restaurantTypeAdapter.dataSet = setRestaurantTypeDummyData()
            binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter*/
        }


/*
        val restaurantTypeAdapter = RestaurantTypeAdapter()
        restaurantTypeAdapter.dataSet = setRestaurantTypeDummyData()
        binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter
*/





        val couponAdapter = CouponAdapter()
        couponAdapter.dataSet = setCouponDummyData()
        binding.recyclerViewCoupon.adapter = couponAdapter




    }

    private fun setRestaurantFamousDummyData(): List<HomeRestResult> {
        val data = listOf<HomeRestResult>(
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1),
                HomeRestResult(0,0,"???????????? ????????????","modify later","modify later","1000",4.9,14,1.1)
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

                    restaurantFamousAdapter.dataSet = famousExtraListCheetah
                    restaurantFamousAdapter.notifyDataSetChanged()
                }else{
                    homeLayoutCheetah.setBackgroundResource(R.drawable.border_shape_2)
                    homeTextCheetah.setTextColor(black_int)

                    restaurantFamousAdapter.dataSet = famousExtraListNonCheetah
                    restaurantFamousAdapter.notifyDataSetChanged()
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
            CategoryResult("1??????","a"),
            CategoryResult("??????","a"),
            CategoryResult("??????","a"),
            CategoryResult("??????","a")    )

        return dataList

    }
/*
    private fun setRestaurantNewProfileDummyData(): MutableList<RestaurantProfileData> {
        var dataList = mutableListOf<RestaurantProfileData>()
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"????????? ?????????","4.1","0","1.3km","2000???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_3,"?????? ?????????","4.0","0","1.7km","3800???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"??????????????? ?????????","5.0","9","1.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"????????? ?????????","4.1","0","1.3km","2000???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"????????? ?????????","4.1","2","1.3km","2000???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"????????? ?????????","4.1","0","1.3km","2000???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"????????? ?????????","4.1","2","1.3km","2000???"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"????????? ?????????","4.1","2","1.3km","2000???"))

        return dataList
    }
*/

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



/*    fun setRestaurantProfileDummyData(): MutableList<RestaurantProfileData>{
        var dataList = mutableListOf<RestaurantProfileData>()
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_2,"????????? ???????????????","4.5","1394","0.9km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_3,"???????????? ????????????","4.9","136","0.4km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        dataList.add(RestaurantProfileData(R.drawable.restaurant_image_1,"???????????? ?????????","4.7","12","0.3km","????????????"))
        return dataList

    }*/

    override fun onGetHomeSuccess(response: HomeResponse) {
//        Log.d("Okhttp","??????: ${response.result.homeUserAddressResult[0].homeAddress}")
//        Log.d("Okhttp","??????: ${response.result.homeUserAddressResult[0].defaultAddressId}")

        val restaurantTypeAdapter = RestaurantTypeAdapter()
        restaurantTypeAdapter.dataSet = response.result.categoryResult
        binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter

        val imageUrlAd1 = response.result.eventResult.get(0).eventImageUrl
        Glide.with(this)
            .load(imageUrlAd1)
            .into(binding.homeAd1)


        //?????????????????????
        val restaurantProfileAdapter = RestaurantProfileAdapter()
        restaurantProfileAdapter.dataSet = response.result.homeRestResult[0]
        binding.recyclerViewFranchise.adapter = restaurantProfileAdapter

        //?????????????????????
        val restaurantNewProfileAdapter = RestaurantProfileAdapter()
        restaurantNewProfileAdapter.dataSet = response.result.homeRestResult[1]
        binding.recyclerViewNewRestaurant.adapter = restaurantNewProfileAdapter

        //??????????????????
        //val restaurantFamousAdapter = RestaurantFamousAdapter()
        restaurantFamousAdapter.dataSet = response.result.homeRestResult[2]
        binding.recyclerViewFamousRestaurant.adapter = restaurantFamousAdapter

        val famousSize = response.result.homeRestResult[2].size
        if(famousSize >3){
            for(i in 1..3){
                famousExtraListCheetah.add(response.result.homeRestResult[2][famousSize-i])
            }
            for(i in 0 until famousSize){
                famousExtraListNonCheetah.add(response.result.homeRestResult[2][i])
            }
        }
        famousExtraListCheetah.toList()



    }

    override fun onGetHomeFailure(message: String) {
        Log.d("Okhttp", "?????? : $message")
    }

    override fun onGetHomeNonLoginSuccess(response: HomeResponse) {
        Log.d("Okhttp",response.message.toString())

        val restaurantTypeAdapter = RestaurantTypeAdapter()
        restaurantTypeAdapter.dataSet = response.result.categoryResult
        binding.recyclerViewRestaurantType.adapter = restaurantTypeAdapter

        val imageUrlAd1 = response.result.eventResult.get(0).eventImageUrl
        Glide.with(this)
            .load(imageUrlAd1)
            .into(binding.homeAd1)


        //?????????????????????
        val restaurantProfileAdapter = RestaurantProfileAdapter()
        restaurantProfileAdapter.dataSet = response.result.homeRestResult[0]
        binding.recyclerViewFranchise.adapter = restaurantProfileAdapter

        //?????????????????????
        val restaurantNewProfileAdapter = RestaurantProfileAdapter()
        restaurantNewProfileAdapter.dataSet = response.result.homeRestResult[1]
        binding.recyclerViewNewRestaurant.adapter = restaurantNewProfileAdapter

        //??????????????????
        val restaurantFamousAdapter = RestaurantFamousAdapter()
        restaurantFamousAdapter.dataSet = response.result.homeRestResult[2]
        binding.recyclerViewFamousRestaurant.adapter = restaurantFamousAdapter



    }

    override fun onGetHomeNonLoginFailure(message: String) {
        Log.d("Okhttp", "?????? : $message")
    }


}