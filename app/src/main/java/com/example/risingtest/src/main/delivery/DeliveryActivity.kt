package com.example.risingtest.src.main.delivery

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityDeliveryBinding
import com.example.risingtest.src.main.MainActivity
import java.lang.Thread.sleep

class DeliveryActivity : BaseActivity<ActivityDeliveryBinding>(ActivityDeliveryBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val totalPrice = intent.getStringExtra("totalPrice")
        val restName = intent.getStringExtra("restName")
        val menuName = intent.getStringExtra("menuName")

        val deliveryThread = DeliveryThread()


        binding.apply {
            duringDeliveryLayout.visibility = View.GONE

            deliveryCancelBtn.setOnClickListener {
                finish()
            }
            totalPriceDelivery.text = totalPrice
            restNameDelivery.text = restName
            deliveryMenuName.text = menuName

            gohomeDelivery.setOnClickListener {
                //초기화면으로
                //모든액티비티 없애고 메인액티비티 다시 띄움(즉 앱 재시작과 같다)
                val i = Intent(this@DeliveryActivity, MainActivity::class.java)
                ActivityCompat.finishAffinity(this@DeliveryActivity)
                startActivity(i)
            }
        }

        deliveryThread.isRunning = true
        deliveryThread.start()

    }
    inner class DeliveryThread : Thread(){
        var isRunning = false
        var timer = 20
        override fun run() {

            while(isRunning){
                runOnUiThread {
                    binding.apply{
                        if(timer == 15){
                            duringDeliveryLayout.visibility = View.VISIBLE
                            beforeDeliveryLayout.visibility = View.GONE
                            timerDelivery.text = "$timer 분"


                        }else if(timer == 7){
                            duringImage.setImageResource(R.drawable.during_delivery_2)
                            timerDelivery.text = "$timer 분"

                        }else if (timer == 1){
                            duringImage.setImageResource(R.drawable.during_delivery_3)
                            timerDelivery.text = "$timer 분"

                        }else if( timer ==0 ){
                            timerDelivery.text = "배달이 완료되었습니다"
                            isRunning = false
                        }
                    }
                }
                timer --

                sleep(1000)



            }

        }
    }
}