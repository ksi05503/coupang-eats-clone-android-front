package com.example.risingtest.src.main.search

import android.content.Intent
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySearchBinding
import com.example.risingtest.src.main.search.models.SearchKewordResponse

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate),
    SearchActivityView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SearchService(this).tryGetSearchKeyword(1)


        binding.searchActivityBtn.setOnClickListener {
            val i = Intent ( this, SubSearchActivity::class.java)
            i.putExtra("keyword",binding.searchActivityEditText.text.toString())
            startActivity(i)
        }
    }

    override fun onGetSearchKewordSuccess(response: SearchKewordResponse) {
        val adapter = SearchKeywordAdapter()
        adapter.dataSet = response.result
        binding.recyclerViewRecentKeyword.adapter = adapter
    }

    override fun onGetSearchKewordFailure(message: String) {

    }
}