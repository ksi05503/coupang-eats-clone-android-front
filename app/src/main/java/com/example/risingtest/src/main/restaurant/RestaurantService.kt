package com.example.risingtest.src.main.restaurant

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.restaurant.models.PostBookmarksRequest
import com.example.risingtest.src.main.restaurant.models.PostBookmarksResponse

import com.example.risingtest.src.main.restaurant.models.MenuResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantService(val view: RestaurantActivityView) {

    fun tryGetMenu(userId:Int, restId:Int){
        val restaurantRetrofitInterface =
            ApplicationClass.sRetrofit.create(RestaurantRetrofitInterface::class.java)

        restaurantRetrofitInterface.getMenu(userId = userId,restId = restId).enqueue(object :
            Callback<MenuResponse> {
            override fun onResponse(call: Call<MenuResponse>, response: Response<MenuResponse>) {
                view.onGetMenuSuccess(response.body() as MenuResponse)
            }

            override fun onFailure(call: Call<MenuResponse>, t: Throwable) {
                view.onGetMenuFailure(t.message ?: "통신 오류")
            }

        }
        )
    }


    fun tryGetMenuNonLogin(restId:Int){
        val restaurantRetrofitInterface =
            ApplicationClass.sRetrofit.create(RestaurantRetrofitInterface::class.java)

        restaurantRetrofitInterface.getMenuNonLogin(restId = restId).enqueue(object :
            Callback<MenuResponse> {
            override fun onResponse(call: Call<MenuResponse>, response: Response<MenuResponse>) {
                view.onGetMenuNonLoginSuccess(response.body() as MenuResponse)
            }

            override fun onFailure(call: Call<MenuResponse>, t: Throwable) {
                view.onGetMenuNonLoginFailure(t.message ?: "통신 오류")
            }

        }
        )
    }


    fun tryPostBookmarks(userId:Int, params: PostBookmarksRequest){
        val restaurantRetrofitInterface =
            ApplicationClass.sRetrofit.create(RestaurantRetrofitInterface::class.java)

        restaurantRetrofitInterface.postBookmarks(userId,params).enqueue( object :
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