package com.example.risingtest.src.main.favorites

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.risingtest.R
import com.example.risingtest.src.main.favorites.models.GetBookmarksResult
import com.example.risingtest.src.main.restaurant.RestaurantActivity


class FavoritesAdapter : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {
    var dataSet = listOf<GetBookmarksResult>()

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.item_famous_restaurant_name)
        val rate: TextView = view.findViewById(R.id.item_famous_restaurant_rate)
        val reviewCount: TextView = view.findViewById(R.id.item_famous_restaurant_review_count)
        val distance: TextView = view.findViewById(R.id.item_famous_restaurant_distance)
        val deliveryCost: TextView = view.findViewById(R.id.item_famous_restaurant_delivery_cost)
        val image: ImageView = view.findViewById(R.id.item_famous_restaurant_image)

        fun setItemInfo(getBookmarksResult: GetBookmarksResult){
            name.text = getBookmarksResult.restName
            rate.text = getBookmarksResult.star.toString()
            val tempStringReviewCount = "(${getBookmarksResult.count_review})"
            reviewCount.text = tempStringReviewCount
            val tempStringDistance = "${getBookmarksResult.distance_KM}km"
            distance.text = tempStringDistance
            var tempStringDeliveryCost = "배달비 ${getBookmarksResult.deliveryFee}"
            if (getBookmarksResult.deliveryFee == "무료배달"){
                tempStringDeliveryCost = "무료배달"
            }
            deliveryCost.text = tempStringDeliveryCost


            Glide.with(image.context)
                .load(getBookmarksResult.repRestImageUrl)
                .apply(
                    RequestOptions().override(350, 350).centerCrop()
                )
                .into(image)
        }

        init {

/*            view.setOnClickListener {
                //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
                val i = Intent(view.context, RestaurantActivity::class.java)
                view.context.startActivity(i)


                Log.d("famousRest recyclerView","뷰 눌렸습니다.")
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_favorites_rest,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)

        holder.itemView.setOnClickListener {
            //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
            val i = Intent(holder.itemView.context, RestaurantActivity::class.java)
            i.putExtra("restId",dataSet[position].restId)
            holder.itemView.context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}