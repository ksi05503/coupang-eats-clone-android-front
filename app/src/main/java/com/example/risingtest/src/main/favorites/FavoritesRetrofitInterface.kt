package com.example.risingtest.src.main.favorites

import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FavoritesRetrofitInterface {

    @GET("/app/users/{userId}/bookmarks")
    fun getBookmarks(@Path("userId")userId:Int) : Call<GetBookmarksResponse>
}