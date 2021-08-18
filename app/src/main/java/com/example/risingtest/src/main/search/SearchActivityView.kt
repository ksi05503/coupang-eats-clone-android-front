package com.example.risingtest.src.main.search

import com.example.risingtest.src.main.search.models.SearchContentResponse
import com.example.risingtest.src.main.search.models.SearchKewordResponse

interface SearchActivityView {
    fun onGetSearchKewordSuccess(response: SearchKewordResponse)
    fun onGetSearchKewordFailure(message: String)

/*    fun onGetSearchContentSuccess(response: SearchContentResponse)
    fun onGetSearchContentFailure(message : String)*/



}