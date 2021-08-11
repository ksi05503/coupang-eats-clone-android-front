package com.example.risingtest.src.main.home

import com.example.risingtest.src.main.home.models.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeRetrofitInterface {

    @GET("/app/users/{userId}/restarurants")
    fun getHome(@Path("userId") userId:Int) : Call<HomeResponse>

    @GET("/app/users/restarurants")
    fun getHomeNonLogin() : Call<HomeResponse>
}