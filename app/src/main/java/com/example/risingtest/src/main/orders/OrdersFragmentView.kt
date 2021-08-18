package com.example.risingtest.src.main.orders

import com.example.risingtest.src.main.orders.models.GetOrdersResponse

interface OrdersFragmentView {
    fun onGetOrdersSuccess(response: GetOrdersResponse)
    fun onGetOrdersFailure(message: String)
}