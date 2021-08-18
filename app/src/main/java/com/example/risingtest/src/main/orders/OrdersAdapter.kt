package com.example.risingtest.src.main.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.risingtest.R
import com.example.risingtest.src.main.orders.models.GetOrdersResult


class OrdersAdapter: RecyclerView.Adapter<OrdersAdapter.ViewHolder>()  {
    var dataSet = listOf<GetOrdersResult>()

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.item_orders_name)
        val time: TextView = view.findViewById(R.id.item_orders_time)
        val detailMenu: TextView = view.findViewById(R.id.item_orders_detail_menu)

        val image: ImageView = view.findViewById(R.id.item_orders_image)

        fun setItemInfo(getOrdersResult: GetOrdersResult){
            name.text = "버거킹 성신여대입구역점"
            //time.text = getOrdersResult.createdAt
            val tempTimeStr = getOrdersResult.createdAt
            time.text = "${tempTimeStr.split("T")[0]} 오후 ${tempTimeStr.split("T")[1].split(":")[0]}:${tempTimeStr.split("T")[1].split(":")[1]}"
            detailMenu.text = getOrdersResult.menuName


            Glide.with(image.context)
                .load("https://user-images.githubusercontent.com/83508073/129164640-7b636ae9-21b3-4ff7-b636-f1f90c6b7771.png")
                .apply(
                    RequestOptions().override(350, 350).centerCrop()
                )
                .into(image)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_orders_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}