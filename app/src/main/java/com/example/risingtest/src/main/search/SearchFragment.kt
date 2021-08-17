package com.example.risingtest.src.main.search

import android.content.Intent
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

        binding.searchFragmentEditText.setOnClickListener {
            val i = Intent(view.context, SearchActivity::class.java)
            startActivity(i)
        }

    }


    fun setRestaurantTypeDummyData(): MutableList<RestaurantType>{
        var dataList =  mutableListOf<RestaurantType>()


        dataList.add(RestaurantType(R.drawable.square_restaurant_type1,"한식"))
        dataList.add(RestaurantType(R.drawable.rest_sqr_search_china,"중식"))
        dataList.add(RestaurantType(R.drawable.rest_sqr_japan,"일식"))
        dataList.add(RestaurantType(R.drawable.rest_sqr_europe,"양식"))
        dataList.add(RestaurantType(R.drawable.rest_sqr_pork_curtlette,"돈까스"))
        dataList.add(RestaurantType(R.drawable.rest_sqr_dessert,"디저트"))

        return dataList
    }

}