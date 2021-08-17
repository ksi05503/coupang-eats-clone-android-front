package com.example.risingtest.src.main.search

import com.example.risingtest.src.main.search.models.SearchContentResponse

interface SubSearchActivityView {

    fun onGetSearchContentSuccess(response: SearchContentResponse)
    fun onGetSearchContentFailure(message : String)
}