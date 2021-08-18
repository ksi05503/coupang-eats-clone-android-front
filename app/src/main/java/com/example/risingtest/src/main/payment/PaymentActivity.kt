package com.example.risingtest.src.main.payment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityPaymentBinding
import com.example.risingtest.src.main.delivery.DeliveryActivity
import com.example.risingtest.src.main.payment.models.PaymentResponse

class PaymentActivity : BaseActivity<ActivityPaymentBinding>(ActivityPaymentBinding::inflate), PaymentActivityView{
    var totalPrice = ""
    var restName = ""
    var menuName = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnShowCart.setOnClickListener {
            val i = Intent(this, DeliveryActivity::class.java)
            i.putExtra("totalPrice",totalPrice)
            i.putExtra("restName",restName)
            i.putExtra("menuName",menuName)
            startActivity(i)
        }

        val cartId =  intent.getIntExtra("cartId",1)
        Log.d("Okhttp", "payment액티비티 / cartId$cartId")

        PaymentService(this).tryGetPayment(cartId)
    }

    override fun onGetPaymentSuccess(response: PaymentResponse) {
        Log.d("Okhttp","성공: ${response.result.cartMenuINfoResult[0].menuName}")

        binding.apply {

      //      paymentAdress.text = response.result.cartAddressResult[0].address
      //      paymentAdressDetail.text = response.result.cartAddressResult[0].addressCategory
            paymentAdressDetail.text = response.result.cartAddressResult[0].address
            paymentRestName.text = response.result.cartRestInfoResult[0].restName
            paymentMenuName.text = response.result.cartMenuINfoResult[0].menuName
            val tempMenuDetail = response.result.cartMenuINfoResult[0].totalAdditionalMenuContents.split(",")[0]
            paymentMenuDetail.text =tempMenuDetail
            paymentMenuPrice.text = response.result.cartMenuINfoResult[0].totalPricePerMenu
            paymentOrderPrice.text = response.result.cartMenuINfoResult[0].totalPricePerMenu
            paymentDeliveryFee.text = response.result.cartDeliveryFeeResult[0].deliveryFee

            val tempDeliveryFee = Integer.parseInt(response.result.cartDeliveryFeeResult[0].deliveryFee.split("원")[0].split("+")[1])
            val tempOrderPrice = Integer.parseInt(response.result.cartMenuINfoResult[0].totalPricePerMenu.split("원")[0])
            paymentTotalPrice.text = "${(tempDeliveryFee + tempOrderPrice)}원"

            paymentBtn.text = "${(tempDeliveryFee + tempOrderPrice)}원 결제하기"


            totalPrice = paymentTotalPrice.text.toString()
            restName = paymentRestName.text.toString()
            menuName = paymentMenuName.text.toString()
        }


    }

    override fun onGetPaymentFailure(message: String) {
        Log.d("Okhttp",message)

    }
}