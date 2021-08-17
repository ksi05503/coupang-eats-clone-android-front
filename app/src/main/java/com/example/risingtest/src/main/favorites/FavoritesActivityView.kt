package com.example.risingtest.src.main.favorites

import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse

interface FavoritesActivityView {

    fun onGetBookmarksSuccess(response: GetBookmarksResponse)
    fun onGetBookmarksFailure(message:String)

}