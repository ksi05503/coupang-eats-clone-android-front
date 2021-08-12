package com.example.risingtest.src.main.payment.models

import com.google.gson.annotations.SerializedName

data class CartAddressResult(

    @SerializedName("addressCategory") val addressCategory : String,
    @SerializedName("address") val address : String
)
