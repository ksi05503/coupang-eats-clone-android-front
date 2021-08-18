package com.example.risingtest.src.main.favorites

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import com.example.risingtest.src.main.favorites.models.PostBookmarksRequest
import com.example.risingtest.src.main.favorites.models.PostBookmarksResponse
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

    fun tryPostBookmarks(userId:Int, params:PostBookmarksRequest){
        val favoritesRetrofitInterface=
            ApplicationClass.sRetrofit.create(FavoritesRetrofitInterface::class.java)

        favoritesRetrofitInterface.postBookmarks(userId,params).enqueue( object :
            Callback<PostBookmarksResponse> {
            override fun onResponse(
                call: Call<PostBookmarksResponse>,
                response: Response<PostBookmarksResponse>
            ) {
                view.onPostBookmarksSuccess(response.body() as PostBookmarksResponse)
            }

            override fun onFailure(call: Call<PostBookmarksResponse>, t: Throwable) {
                view.onPostBookmarksFailure(t.message ?: "통신 오류")
            }

        }

        )
    }
}