package com.example.risingtest.src.main.recently

import com.example.risingtest.src.main.recently.models.RecentlyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecentlyRetrofitInterface {

    @GET("/app/users/{userId}/restaurants/recently-openings")
    fun getRecently(@Path("userId") userId : Int,
                      @Query("Cheetah") Cheetah:String,
                      @Query("deliveryFee")deliveryFee:Int,
                      @Query("minimumAmount")minimumAmount:Int ) : Call<RecentlyResponse>
}