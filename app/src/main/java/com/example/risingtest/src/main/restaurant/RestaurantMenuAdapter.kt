package com.example.risingtest.src.main.restaurant

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.src.cart.CartActivity
import com.example.risingtest.src.main.restaurant.models.MenuResult

class RestaurantMenuAdapter : RecyclerView.Adapter<RestaurantMenuAdapter.ViewHolder>() {

    var dataSet = listOf<MenuResult>()

    class ViewHolder(view : View):RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.item_menu_name)
        val detail: TextView = view.findViewById(R.id.item_menu_detail)
        val price: TextView = view.findViewById(R.id.item_menu_price)
        val image: ImageView = view.findViewById(R.id.item_menu_image)

        fun setItemInfo(menuResult: MenuResult){
            name.text = menuResult.menuName
            detail.text = menuResult.menuInfo
            price.text = menuResult.menuprice
            image.setImageResource(R.drawable.restaurant_image_1)
/*            Glide.with(image.context)
                .load(menuResult.menuImageUrl)
                .into(image)*/

        }


        init {
/*
            view.setOnClickListener {
*//*                //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
                val i = Intent(view.context, RestaurantActivity::class.java)
                view.context.startActivity(i)*//*

            }*/
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_menu,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context , CartActivity::class.java)
            i.putExtra("menuId",dataSet[position].menuId)
            holder.itemView.context.startActivity(i)
        }

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}