package com.example.risingtest.src.main.search

import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.src.main.search.models.GetSearchContentRequest
import com.example.risingtest.src.main.search.models.SearchContentResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubSearchService (val view: SubSearchActivityView){

    fun tryGetSearchContent(userId: Int, params: GetSearchContentRequest){
        val searchContentRetrofitInterface = ApplicationClass.sRetrofit.create(SearchRetrofitInterface::class.java)
        searchContentRetrofitInterface.getSearchContent(userId,params).enqueue(object :
            Callback<SearchContentResponse> {
            override fun onResponse(
                call: Call<SearchContentResponse>,
                response: Response<SearchContentResponse>
            ) {
                view.onGetSearchContentSuccess(response.body() as SearchContentResponse)
            }

            override fun onFailure(call: Call<SearchContentResponse>, t: Throwable) {
                view.onGetSearchContentFailure(t.message ?: "통신 오류")
            }

        }
        )
    }

}