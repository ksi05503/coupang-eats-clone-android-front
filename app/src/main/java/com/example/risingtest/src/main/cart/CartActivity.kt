package com.example.risingtest.src.main.cart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.config.BaseResponse
import com.example.risingtest.databinding.ActivityCartBinding
import com.example.risingtest.src.main.cart.models.DetailMenuResponse
import com.example.risingtest.src.main.cart.models.NewCartResponse
import com.example.risingtest.src.main.cart.models.PostAddMenuRequest
import com.example.risingtest.src.main.cart.models.PostNewCartsRequest
import com.example.risingtest.src.main.BottomSheet
import com.example.risingtest.src.main.restaurant.RestaurantActivity

class CartActivity : BaseActivity<ActivityCartBinding>(ActivityCartBinding::inflate),CartActivityView{
    private var cartId = 0
    private var totalPrice =0
    private var priceOfOne = 0
    private var amount = 1
    private var menuId = 1
    private var restId = 1
    private var tempAdditionalMenuId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBtnClickListener()

        if(intent.hasExtra("menuId")){
            menuId = intent.getIntExtra("menuId",1)
        }

        CartService(this).tryGetDetailMenu(menuId)


        if(intent.hasExtra("cartId")){
            cartId = intent.getIntExtra("cartId",0)
            Log.d("Okhttp","cartId getExtra 성공/ cartId : $cartId")

        }
        Log.d("Okhttp","CartActivity 생성/ cartId = $cartId")
/*

        if(checkIsLogin() && cartId <= 0 ){
            //카트생성한채로 메뉴 구경
                Log.d("CartCheck", "restId : ${restId} 로 카트 생성")
            val postNewCartsRequest= PostNewCartsRequest(ApplicationClass.sSharedPreferences.getInt("MY_USERID",0),restId)
            CartService(this).tryPostNewCart(postNewCartsRequest)

        }else{
            //비로그인은 세부메뉴창에들어와도 카트생성API를 사용하지 않음 (조회만하는거)
        }

*/

        //비로그인 시 카트담기 누르면  로그인 바텀다이얼로그
        if(!checkIsLogin()){
            binding.btnAddCart.setOnClickListener {
                //bottom sheet 로그인 다이얼로그 띄우기
                val bottomSheet = BottomSheet(0)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

        }





    }

    private fun initBtnClickListener() {
        binding.apply {
            menuBtnPlus.setOnClickListener {
                amount += 1
                menuAmount.text = amount.toString()
                setTotalPrice()
            }
            menuBtnMinus.setOnClickListener {
                if(amount>1){
                    amount -= 1
                    menuAmount.text = amount.toString()
                    setTotalPrice()
                }
            }



            //카트에담기
            if(checkIsLogin()){
                btnAddCart.setOnClickListener {
                    val postAddMenuRequest = PostAddMenuRequest(cartId = cartId , menuId = menuId, menuCount = amount, additionalMenuId = tempAdditionalMenuId)
                    Log.d("Okhttp","menuCount:$amount 개")
                    CartService(this@CartActivity).tryPostAddMenu(postAddMenuRequest)
                }
            }

        }
    }

    private fun setTotalPrice() {
        //total price 수정
        totalPrice = priceOfOne * amount
        binding.cartTotalPrice.text = "${totalPrice}원"
    }

    override fun onPostNewCartSuccess(response: NewCartResponse) {
        Log.d("Okhttp","카트생성 성공: ${response.result.cartIdResult}번 카트")
        cartId = response.result.cartIdResult

    }

    override fun onPostNewCartFailure(message: String) {
        Log.d("Okhttp",message)
    }

    override fun onGetDetailMenuSuccess(response: DetailMenuResponse) {
        Log.d("Okhttp","detail메뉴 성공: ${response.result.restAdditionalMenuResult.size}개의 세부메뉴")

        tempAdditionalMenuId = response.result.restAdditionalMenuResult[0].additionalMenuId

        restId = response.result.restMenuResult[0].restId
        Log.d("CartCheck","restId에 $restId 대입")
        val detailMenuAdapter = DetailMenuAdapter()
        detailMenuAdapter.dataSet = response.result.restAdditionalMenuResult
        binding.recyclerViewDetailMenu.adapter = detailMenuAdapter

        //카트생성
        if(checkIsLogin() && cartId <= 0 ){
            //카트생성한채로 메뉴 구경
            Log.d("CartCheck", "restId : ${restId} 로 카트 생성")
            val postNewCartsRequest= PostNewCartsRequest(ApplicationClass.sSharedPreferences.getInt("MY_USERID",0),restId)
            CartService(this).tryPostNewCart(postNewCartsRequest)

        }else{
            //비로그인은 세부메뉴창에들어와도 카트생성API를 사용하지 않음 (조회만하는거)
        }



        //카트 레이아웃
        binding.apply {
            cartMenuName.text = response.result.restMenuResult[0].menuName
            cartMenuDetail.text = response.result.restMenuResult[0].menuInfo
/*            Glide.with(this@CartActivity)
                .load(response.result.restMenuResult[0].menuImageUrl)
                .into(cartMainImage)*/
            priceOfOne = response.result.restMenuResult[0].menuPrice
            totalPrice = priceOfOne
            cartTotalPrice.text = "${totalPrice}원"




        }



    }
    override fun onGetDetailMenuFailure(message: String) {
        Log.d("Okhttp",message)
    }

    override fun onPostAddMenuSuccess(response: BaseResponse) {
        Log.d("Okhttp","${cartId}카트에 메뉴추가성공")
        val i = Intent(this, RestaurantActivity::class.java)
        i.putExtra("cartId", cartId)
        i.putExtra("totalPrice",totalPrice)
        i.putExtra("restId",restId)
        finish()
        startActivity(i)

    }

    override fun onPostAddMenuFailure(message: String) {
        Log.d("Okhttp",message)
    }

    override fun onDestroy() {
        super.onDestroy()
        cartId = 0
        totalPrice =0
        priceOfOne = 0
        amount = 1
        menuId = 1
    }
}