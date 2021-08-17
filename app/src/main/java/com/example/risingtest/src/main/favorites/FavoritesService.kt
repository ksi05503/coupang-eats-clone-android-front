package com.example.risingtest.src.main.favorites

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoritesService(val view: FavoritesActivityView) {


    fun tryGetBookmarks(userId:Int){
        val favoritesRetrofitInterface=
            ApplicationClass.sRetrofit.create(FavoritesRetrofitInterface::class.java)

        favoritesRetrofitInterface.getBookmarks(userId).enqueue( object :
            Callback<GetBookmarksResponse> {
            override fun onResponse(
                call: Call<GetBookmarksResponse>,
                response: Response<GetBookmarksResponse>
            ) {
                view.onGetBookmarksSuccess(response.body() as GetBookmarksResponse)
            }

            override fun onFailure(call: Call<GetBookmarksResponse>, t: Throwable) {
                view.onGetBookmarksFailure(t.message ?: "통신 오류")
            }

        }

        )
    }
}