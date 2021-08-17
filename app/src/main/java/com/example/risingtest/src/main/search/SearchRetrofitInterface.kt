package com.example.risingtest.src.main.search

import com.example.risingtest.src.main.search.models.SearchKewordResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchRetrofitInterface {
    @GET("/app/users/{userId}/searches/recent")
    fun getSearchKeyword(@Path("userId")userId:Int) : Call<SearchKewordResponse>


}