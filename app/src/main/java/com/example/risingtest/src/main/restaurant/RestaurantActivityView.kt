package com.example.risingtest.src.main.restaurant

import com.example.risingtest.src.main.restaurant.models.PostBookmarksResponse
import com.example.risingtest.src.main.restaurant.models.MenuResponse

interface RestaurantActivityView {
    fun onGetMenuSuccess(response: MenuResponse)
    fun onGetMenuFailure(message: String)

    fun onGetMenuNonLoginSuccess(response: MenuResponse)
    fun onGetMenuNonLoginFailure(message: String)

    fun onPostBookmarksSuccess(response: PostBookmarksResponse)
    fun onPostBookmarksFailure(message:String)

}