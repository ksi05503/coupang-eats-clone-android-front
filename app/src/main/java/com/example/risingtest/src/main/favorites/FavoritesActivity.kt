package com.example.risingtest.src.main.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityFavoritesBinding
import com.example.risingtest.src.main.favorites.models.GetBookmarksResponse
import com.example.risingtest.src.main.favorites.models.PostBookmarksResponse
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

        binding.favoritesSizeText.text = "총 ${response.result.size}개"


    }

    override fun onGetBookmarksFailure(message: String) {

    }

    override fun onPostBookmarksSuccess(response: PostBookmarksResponse) {
    }

    override fun onPostBookmarksFailure(message: String) {
    }
}