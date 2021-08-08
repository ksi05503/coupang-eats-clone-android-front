package com.example.risingtest.src.main.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R

class CouponAdapter: RecyclerView.Adapter<CouponAdapter.ViewHolder>() {
    var dataSet = mutableListOf<Int>()
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.item_image_view_coupon_image)
        fun setItemInfo(imgResId:Int){
            image.setImageResource(imgResId)
        }
        init {
            view.setOnClickListener {
                Log.d("Rtype recyclerView","뷰 눌렸습니다.")
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_coupon,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CouponAdapter.ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}