package com.example.risingtest.src.main.cart

import com.example.risingtest.config.BaseResponse
import com.example.risingtest.src.main.cart.models.DetailMenuResponse
import com.example.risingtest.src.main.cart.models.NewCartResponse

interface CartActivityView {

    fun onPostNewCartSuccess(response: NewCartResponse)
    fun onPostNewCartFailure(message: String)

    fun onGetDetailMenuSuccess(response: DetailMenuResponse)
    fun onGetDetailMenuFailure(message: String)

    fun onPostAddMenuSuccess(response: BaseResponse)
    fun onPostAddMenuFailure(message: String)
}