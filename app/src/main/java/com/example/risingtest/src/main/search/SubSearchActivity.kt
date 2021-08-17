package com.example.risingtest.src.main.search

import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivitySubSearchBinding
import com.example.risingtest.src.main.search.models.GetSearchContentRequest
import com.example.risingtest.src.main.search.models.SearchContentResponse
import com.example.risingtest.src.main.search.models.SearchContentResult

class SubSearchActivity : BaseActivity<ActivitySubSearchBinding>(ActivitySubSearchBinding::inflate),SubSearchActivityView  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val keyword = intent.getStringExtra("keyword")

        binding.searchSubActivityEditText.setText(keyword)


        //임시
        val adapter = SearchContentRestAdapter()
        adapter.dataSet = listOf(SearchContentResult(2,1,"응급실국물떡볶이 안암점",
            "https://user-images.githubusercontent.com/83508073/129164333-5d24f3b4-6e1f-4e8a-82e5-5f8f5527523a.png",
            "https://user-images.githubusercontent.com/83508073/129164508-6234ee67-80de-4389-96c0-058fa7cc18df.png",
            "Y",5.0,18,5.98))
        binding.subSearchRecyclerView.adapter = adapter

/*
        val getSearchContentRequest = GetSearchContentRequest(keyword!!)
        SubSearchService(this).tryGetSearchContent(1,getSearchContentRequest)
*/

    }

    override fun onGetSearchContentSuccess(response: SearchContentResponse) {
        Log.d("Okhttp","SubSearch 성공 / 개수:${response.result.size}")

        //어댑터장착
        val adapter = SearchContentRestAdapter()
        adapter.dataSet = response.result
        binding.subSearchRecyclerView.adapter = adapter
    }

    override fun onGetSearchContentFailure(message: String) {

        Log.d("Okhttp","SubSearch 실패")
        Log.d("Okhttp",message)

    }


}