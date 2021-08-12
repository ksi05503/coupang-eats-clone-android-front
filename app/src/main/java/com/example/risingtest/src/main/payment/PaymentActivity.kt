package com.example.risingtest.src.main.payment

import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityPaymentBinding
import com.example.risingtest.src.main.payment.models.PaymentResponse

class PaymentActivity : BaseActivity<ActivityPaymentBinding>(ActivityPaymentBinding::inflate), PaymentActivityView{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cartId =  intent.getIntExtra("cartId",1)

        PaymentService(this).tryGetPayment(cartId)
    }

    override fun onGetPaymentSuccess(response: PaymentResponse) {
        Log.d("Okhttp","성공: ${response.result.cartMenuINfoResult[0].menuName}")

        binding.apply {
            paymentAdress.text = response.result.cartAddressResult[0].address
            paymentAdressDetail.text = response.result.cartAddressResult[0].addressCategory
            paymentRestName.text = response.result.cartRestInfoResult[0].restName
            paymentMenuName.text = response.result.cartMenuINfoResult[0].menuName
            paymentMenuDetail.text =response.result.cartMenuINfoResult[0].totalAdditionalMenuContents
            paymentMenuPrice.text = response.result.cartMenuINfoResult[0].totalPricePerMenu
            paymentOrderPrice.text = response.result.cartMenuINfoResult[0].totalPricePerMenu
            paymentDeliveryFee.text = response.result.cartDeliveryFeeResult[0].deliveryFee

            val tempDeliveryFee = Integer.parseInt(response.result.cartDeliveryFeeResult[0].deliveryFee.split("원")[0].split("+")[1])
            val tempOrderPrice = Integer.parseInt(response.result.cartMenuINfoResult[0].totalPricePerMenu.split("원")[0])
            paymentTotalPrice.text = "${(tempDeliveryFee + tempOrderPrice)}원"

            paymentBtn.text = "${(tempDeliveryFee + tempOrderPrice)}원 결제하기"

        }


    }

    override fun onGetPaymentFailure(message: String) {
        Log.d("Okhttp",message)

    }
}