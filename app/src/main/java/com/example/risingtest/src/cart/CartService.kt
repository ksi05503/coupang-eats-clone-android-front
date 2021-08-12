package com.example.risingtest.src.cart

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.cart.models.DetailMenuResponse
import com.example.risingtest.src.cart.models.NewCartResponse
import com.example.risingtest.src.cart.models.PostNewCartsRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartService(val view: CartActivityView) {
    fun tryPostNewCart(postNewCartsRequest: PostNewCartsRequest) {

        val cartRetrofitInterface = ApplicationClass.sRetrofit.create(CartRetrofitInterface::class.java)
        cartRetrofitInterface.postNewCart(postNewCartsRequest).enqueue(object :
            Callback<NewCartResponse> {
            override fun onResponse(call: Call<NewCartResponse>, response: Response<NewCartResponse>) {
                view.onPostNewCartSuccess(response.body() as NewCartResponse)
            }

            override fun onFailure(call: Call<NewCartResponse>, t: Throwable) {
                view.onPostNewCartFailure(t.message ?: "통신 오류")
            }
        })

    }
    fun tryGetDetailMenu(menuId: Int){
        val cartRetrofitInterface = ApplicationClass.sRetrofit.create(CartRetrofitInterface::class.java)
        cartRetrofitInterface.getDetailMenu(menuId).enqueue(object :
            Callback<DetailMenuResponse>{
            override fun onResponse(
                call: Call<DetailMenuResponse>,
                response: Response<DetailMenuResponse>
            ) {
                view.onGetDetailMenuSuccess(response.body() as DetailMenuResponse)
            }

            override fun onFailure(call: Call<DetailMenuResponse>, t: Throwable) {
                view.onGetDetailMenuFailure(t.message ?: "통신 오류")
            }

            })
    }
}