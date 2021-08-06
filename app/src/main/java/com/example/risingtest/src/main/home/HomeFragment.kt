package com.example.risingtest.src.main.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.risingtest.R
import com.example.risingtest.config.BaseFragment
import com.example.risingtest.databinding.FragmentHomeBinding
import com.example.risingtest.src.main.home.models.RestaurantType

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home)    {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var dataList =  mutableListOf<RestaurantType>()
        dataList.add(RestaurantType(R.drawable.round_png_type1,"신규 맛집"))
        dataList.add(RestaurantType(R.drawable.round_png_type2,"1인분"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))
        dataList.add(RestaurantType(R.drawable.round_png_type3,"한식"))


        val adapter = RestaurantTypeAdapter()
        adapter.dataSet = dataList
        binding.recyclerViewRestaurantType.adapter = adapter

    }



}