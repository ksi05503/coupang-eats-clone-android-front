package com.example.risingtest.src.main.franchises

import com.example.risingtest.src.main.franchises.models.FranchisesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FranchisesRetrofitInterface {
    @GET("/app/users/{userId}/restaurants/franchises")
    fun getFranchises(@Path("userId") userId : Int,
                      @Query("Cheetah") Cheetah:String,
                      @Query("deliveryFee")deliveryFee:Int,
                      @Query ("minimumAmount")minimumAmount:Int ) : Call<FranchisesResponse>
}