package com.example.risingtest.src.main.recently

import com.example.risingtest.src.main.recently.models.RecentlyResponse

interface RecentlyActivityView {
    fun onGetRecentlySuccess(response: RecentlyResponse)
    fun onGetRecentlyFailure(message: String)
}