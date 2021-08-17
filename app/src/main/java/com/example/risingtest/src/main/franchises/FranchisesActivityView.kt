package com.example.risingtest.src.main.franchises

import com.example.risingtest.src.main.franchises.models.FranchisesResponse

interface FranchisesActivityView {
    fun onGetFranchisesSuccess(response: FranchisesResponse)
    fun onGetFranchisesFailure(message: String)
}