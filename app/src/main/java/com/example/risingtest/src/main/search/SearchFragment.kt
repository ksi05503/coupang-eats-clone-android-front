package com.example.risingtest.src.main.search

import android.os.Bundle
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentSearchBinding
import com.example.risingtest.src.main.RestaurantType

class SearchFragment :
    BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::bind, R.layout.fragment_search) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val searchRestaurantTypeAdapter = SearchRestaurantTypeAdapter()
        searchRestaurantTypeAdapter.dataSet = setRestaurantTypeDummyData()
        binding.recyclerViewSearchTypeGrid.adapter = searchRestaurantTypeAdapter


    }


    fun setRestaurantTypeDummyData(): MutableList<RestaurantType>{
        var dataList =  mutableListOf<RestaurantType>()

        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"신규 맛집"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"1인분"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))

        return dataList
    }

}