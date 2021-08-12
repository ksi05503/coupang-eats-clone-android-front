package com.example.risingtest.src.cart

import com.example.risingtest.src.cart.models.DetailMenuResponse
import com.example.risingtest.src.cart.models.NewCartResponse

interface CartActivityView {

    fun onPostNewCartSuccess(response: NewCartResponse)
    fun onPostNewCartFailure(message: String)

    fun onGetDetailMenuSuccess(response: DetailMenuResponse)
    fun onGetDetailMenuFailure(message: String)
}