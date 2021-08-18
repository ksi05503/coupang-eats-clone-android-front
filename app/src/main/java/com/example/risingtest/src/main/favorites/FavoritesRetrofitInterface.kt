package com.example.risingtest.src.main.favorites

import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import com.example.risingtest.src.main.favorites.models.PostBookmarksRequest
import com.example.risingtest.src.main.favorites.models.PostBookmarksResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoritesRetrofitInterface {

    @GET("/app/users/{userId}/bookmarks")
    fun getBookmarks(@Path("userId")userId:Int) : Call<GetBookmarksResponse>

    @POST("/app/users/{userId}/bookmarks")
    fun postBookmarks(@Path("userId")userId:Int, @Body params:PostBookmarksRequest) : Call<PostBookmarksResponse>
}