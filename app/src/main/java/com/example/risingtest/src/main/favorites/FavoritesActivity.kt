package com.example.risingtest.src.main.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityFavoritesBinding
import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import com.example.risingtest.src.main.search.SearchRestaurantTypeAdapter


class FavoritesActivity : BaseActivity<ActivityFavoritesBinding>(ActivityFavoritesBinding::inflate),FavoritesActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FavoritesService(this).tryGetBookmarks(1)
    }

    override fun onGetBookmarksSuccess(response: GetBookmarksResponse) {
        val adapter = FavoritesAdapter()
        adapter.dataSet = response.result
        binding.favoritesRecyclerView.adapter = adapter
    }

    override fun onGetBookmarksFailure(message: String) {

    }
}