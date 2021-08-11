package com.example.risingtest.src.main.home

import com.example.risingtest.src.main.home.models.HomeResponse

interface HomeFragmentView {

    fun onGetHomeSuccess(response: HomeResponse)
    fun onGetHomeFailure(message:String)

    fun onGetHomeNonLoginSuccess(response: HomeResponse)
    fun onGetHomeNonLoginFailure(message: String)
}