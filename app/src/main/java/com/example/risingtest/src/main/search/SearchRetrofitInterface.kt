package com.example.risingtest.src.main.search

import com.example.risingtest.src.main.search.models.SearchContentResponse
import com.example.risingtest.src.main.search.models.SearchKewordResponse
import com.example.risingtest.src.main.search.models.GetSearchContentRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.HTTP




interface SearchRetrofitInterface {
    @GET("/app/users/{userId}/searches/recent")
    fun getSearchKeyword(@Path("userId")userId:Int) : Call<SearchKewordResponse>


    @GET("/app/users/{userId}/searches")
    fun getSearchContent1(@Path("userId")userId:Int,@Body params: GetSearchContentRequest) : Call<SearchContentResponse>

    @HTTP(method = "GET", path = "/app/users/{userId}/searches", hasBody = true)
    fun getSearchContent(
        @Path("userId") userId: Int,
        @Body params: GetSearchContentRequest
    ): Call<SearchContentResponse>
}