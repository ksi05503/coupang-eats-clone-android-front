package com.example.risingtest.src.main.search


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.RestaurantType

//  adapter.notifyDataSetChanged() 데이터 리스트 변화있을때 이거하면 업데이트 된다.


class SearchRestaurantTypeAdapter(): RecyclerView.Adapter<SearchRestaurantTypeAdapter.ViewHolder>() {
    var dataSet = mutableListOf<RestaurantType>()
    class ViewHolder(view : View):RecyclerView.ViewHolder(view){

        val textView: TextView = view.findViewById(R.id.item_text_search_restaurant_name)
        val imageView: ImageView = view.findViewById(R.id.item_image_view_search_restaurant_type)
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
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_search_restaurant_type,parent,false)
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