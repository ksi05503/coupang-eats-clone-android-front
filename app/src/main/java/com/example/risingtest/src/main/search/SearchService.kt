package com.example.risingtest.src.main.search

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.search.models.SearchKewordResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService(val view:SearchActivityView) {

    fun tryGetSearchKeyword(userId: Int){
        val searchKeywordRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)

        searchKeywordRetrofitInterface.getSearchKeyword(userId).enqueue( object :
            Callback<SearchKewordResponse>{
            override fun onResponse(
                call: Call<SearchKewordResponse>,
                response: Response<SearchKewordResponse>
            ) {
                view.onGetSearchKewordSuccess(response.body() as SearchKewordResponse)
            }

            override fun onFailure(call: Call<SearchKewordResponse>, t: Throwable) {
                view.onGetSearchKewordFailure(t.message ?: "통신 오류")

            }

        }
        )


    }
}