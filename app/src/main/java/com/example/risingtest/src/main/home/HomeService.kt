package com.example.risingtest.src.main.home

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun tryGetHome(userId:Int){
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)

        homeRetrofitInterface.getHome(userId = userId).enqueue(object :
            Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onGetHomeSuccess(response.body() as HomeResponse)
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onGetHomeFailure(t.message ?: "통신 오류")
            }

        }
        )

    }

}