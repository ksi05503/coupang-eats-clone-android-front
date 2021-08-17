package com.example.risingtest.src.main.recently

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityRecentlyBinding
import com.example.risingtest.src.main.recently.models.RecentlyResponse
import com.example.risingtest.src.main.search.SearchActivity

class RecentlyActivity : BaseActivity<ActivityRecentlyBinding>(ActivityRecentlyBinding::inflate), RecentlyActivityView {
    private val filterArray = arrayOf(false,false,false,false,false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        RecentlyService(this).tryGetRecently(1,"N",100000,100000)

        binding.recentlySearchBtn.setOnClickListener {
            val i = Intent (this, SearchActivity::class.java)
            startActivity(i)
        }
    }

    override fun onGetRecentlySuccess(response: RecentlyResponse) {
        val adapter = RestaurantRecentlyAdapter()
         adapter.dataSet = response.result
         binding.recyclerViewRecentlyRestaurant.adapter = adapter
    }

    override fun onGetRecentlyFailure(message: String) {
        Log.d("Okhttp",message)
    }
}