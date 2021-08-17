package com.example.risingtest.src.main.recently

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.recently.models.RecentlyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecentlyService(val view:RecentlyActivityView) {

    fun tryGetRecently(userId:Int, Cheetah:String, deliveryFee:Int, minimumAmount:Int){
        val recentlyRetrofitInterface=
            ApplicationClass.sRetrofit.create(RecentlyRetrofitInterface::class.java)

        recentlyRetrofitInterface.getRecently(userId, Cheetah, deliveryFee, minimumAmount).enqueue( object :
            Callback<RecentlyResponse> {
            override fun onResponse(
                call: Call<RecentlyResponse>,
                response: Response<RecentlyResponse>
            ) {
                view.onGetRecentlySuccess(response.body() as RecentlyResponse)
            }

            override fun onFailure(call: Call<RecentlyResponse>, t: Throwable) {
                view.onGetRecentlyFailure(t.message ?: "통신 오류")
            }

        }

        )
    }
}