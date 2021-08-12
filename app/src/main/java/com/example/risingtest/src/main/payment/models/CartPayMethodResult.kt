package com.example.risingtest.src.main.payment.models

import android.accounts.Account
import com.google.gson.annotations.SerializedName

data class CartPayMethodResult(
    @SerializedName("card") val card : List<String>,
    @SerializedName("account") val account : List<Account>
)
