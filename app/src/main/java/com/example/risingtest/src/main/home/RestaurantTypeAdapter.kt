package com.example.risingtest.src.main.home

import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.home.models.RestaurantType

class RestaurantTypeAdapter(private val dataSet: List<RestaurantType>): RecyclerView.Adapter<RestaurantTypeAdapter.ViewHolder>() {

    class ViewHolder(view : View):RecyclerView.ViewHolder(view){

        val textView: TextView = view.findViewById(R.id.item_restaurant_type_text)
        val imageView: ImageView = view.findViewById(R.id.item_restaurant_type_image)
        fun setItemInfo(restaurantType: RestaurantType){
            textView.text = restaurantType.name
            imageView.setImageResource(restaurantType.resId)  // 나중에 uri 로 고쳐서 서버연동하면될듯
        }

        init {
            view.setOnClickListener {
                Log.d("Rtype recyclerView","뷰 눌렸습니다.")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_type,parent,false)
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