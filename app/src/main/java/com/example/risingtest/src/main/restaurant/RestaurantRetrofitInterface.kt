package com.example.risingtest.src.main.restaurant

import com.example.risingtest.src.main.restaurant.models.PostBookmarksRequest
import com.example.risingtest.src.main.restaurant.models.PostBookmarksResponse
import com.example.risingtest.src.main.restaurant.models.MenuResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestaurantRetrofitInterface {
    @GET("/app/users/{userId}/restaurants/{restId}")
    fun getMenu(@Path("userId") userId:Int,@Path("restId") restId:Int) : Call<MenuResponse>

    @GET("/app/users/restaurants/{restId}")
    fun getMenuNonLogin(@Path("restId") restId:Int) : Call<MenuResponse>

    @POST("/app/users/{userId}/bookmarks")
    fun postBookmarks(@Path("userId")userId:Int, @Body params: PostBookmarksRequest) : Call<PostBookmarksResponse>
}