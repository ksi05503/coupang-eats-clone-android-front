package com.example.risingtest.src.main.orders

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentOrdersBinding
import com.example.risingtest.src.main.orders.models.GetOrdersResponse

class OrdersFragment: BaseFragment<FragmentOrdersBinding>(FragmentOrdersBinding::bind, R.layout.fragment_orders),OrdersFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OrdersService(this).tryGetOrders(1)

    }

    override fun onGetOrdersSuccess(response: GetOrdersResponse) {
        val adapter = OrdersAdapter()
        adapter.dataSet = response.result
        binding.ordersRecyclerView.adapter = adapter
    }

    override fun onGetOrdersFailure(message: String) {

    }


}