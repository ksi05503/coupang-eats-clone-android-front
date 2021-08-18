package com.example.risingtest.src.main.favorites

import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import com.example.risingtest.src.main.favorites.models.PostBookmarksResponse

interface FavoritesActivityView {

    fun onGetBookmarksSuccess(response: GetBookmarksResponse)
    fun onGetBookmarksFailure(message:String)

    fun onPostBookmarksSuccess(response: PostBookmarksResponse)
    fun onPostBookmarksFailure(message:String)

}