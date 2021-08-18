package com.example.risingtest.src.main.search

import android.content.Intent
import android.os.Bundle
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySearchBinding
import com.example.risingtest.src.main.search.models.SearchKewordResponse
import com.example.risingtest.src.main.search.models.SearchKewordResult
import java.util.*

class SearchActivity : BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate),
    SearchActivityView {
    var list = mutableListOf<SearchKewordResult>()
    val adapter = SearchKeywordAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SearchService(this).tryGetSearchKeyword(1)


        binding.searchActivityBtn.setOnClickListener {
            val i = Intent ( this, SubSearchActivity::class.java)
            i.putExtra("keyword",binding.searchActivityEditText.text.toString())
            list.add(SearchKewordResult("떡볶이","08-19"))
            adapter.notifyDataSetChanged()
            startActivity(i)
        }
    }

    override fun onGetSearchKewordSuccess(response: SearchKewordResponse) {
        list = response.result.toMutableList()
        adapter.dataSet = list.asReversed()
        binding.recyclerViewRecentKeyword.adapter = adapter
    }

    override fun onGetSearchKewordFailure(message: String) {

    }
}