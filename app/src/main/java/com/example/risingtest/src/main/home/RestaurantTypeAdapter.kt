package com.example.risingtest.src.main.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.RestaurantType
import com.example.risingtest.src.main.restaurant.RestaurantActivity

//  adapter.notifyDataSetChanged() 데이터 리스트 변화있을때 이거하면 업데이트 된다.


class RestaurantTypeAdapter(): RecyclerView.Adapter<RestaurantTypeAdapter.ViewHolder>() {
    var dataSet = mutableListOf<RestaurantType>()
    class ViewHolder(view : View):RecyclerView.ViewHolder(view){

        val textView: TextView = view.findViewById(R.id.item_restaurant_type_text)
        val imageView: ImageView = view.findViewById(R.id.item_restaurant_type_image)
        fun setItemInfo(restaurantType: RestaurantType){
            textView.text = restaurantType.name
            imageView.setImageResource(restaurantType.resId)  // 나중에 uri 로 고쳐서 서버연동하면될듯
        }

        init {

            view.setOnClickListener {
                //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
                val i = Intent(view.context, RestaurantActivity::class.java)
                view.context.startActivity(i)


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