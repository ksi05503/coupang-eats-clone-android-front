package com.example.risingtest.src.main.franchises

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.franchises.models.FranchisesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FranchisesService(val view: FranchisesActivityView) {

    fun tryGetFranchises(userId:Int, Cheetah:String, deliveryFee:Int, minimumAmount:Int){
        val franchisesRetrofitInterface=
            ApplicationClass.sRetrofit.create(FranchisesRetrofitInterface::class.java)

        franchisesRetrofitInterface.getFranchises(userId, Cheetah, deliveryFee, minimumAmount).enqueue( object :
            Callback<FranchisesResponse>{
            override fun onResponse(
                call: Call<FranchisesResponse>,
                response: Response<FranchisesResponse>
            ) {
                view.onGetFranchisesSuccess(response.body() as FranchisesResponse)
            }

            override fun onFailure(call: Call<FranchisesResponse>, t: Throwable) {
                view.onGetFranchisesFailure(t.message ?: "통신 오류")
            }

        }

        )
    }

}