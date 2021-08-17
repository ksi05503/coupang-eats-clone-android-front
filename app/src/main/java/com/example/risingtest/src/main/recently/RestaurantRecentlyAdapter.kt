package com.example.risingtest.src.main.recently

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.risingtest.R
import com.example.risingtest.src.main.franchises.models.FranchisesResult
import com.example.risingtest.src.main.recently.models.RecentlyResult

import com.example.risingtest.src.main.restaurant.RestaurantActivity


class RestaurantRecentlyAdapter: RecyclerView.Adapter<RestaurantRecentlyAdapter.ViewHolder>()  {
    var dataSet = listOf<RecentlyResult>()

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.item_famous_restaurant_name)
        val rate: TextView = view.findViewById(R.id.item_famous_restaurant_rate)
        val reviewCount: TextView = view.findViewById(R.id.item_famous_restaurant_review_count)
        val distance: TextView = view.findViewById(R.id.item_famous_restaurant_distance)
        val deliveryCost: TextView = view.findViewById(R.id.item_famous_restaurant_delivery_cost)
        val image: ImageView = view.findViewById(R.id.item_famous_restaurant_image)

        fun setItemInfo(recentlyResult: RecentlyResult){
            name.text = recentlyResult.restName
            rate.text = recentlyResult.star.toString()
            val tempStringReviewCount = "(${recentlyResult.count_review})"
            reviewCount.text = tempStringReviewCount
            val tempStringDistance = "${recentlyResult.distance_KM}km"
            distance.text = tempStringDistance
            var tempStringDeliveryCost = "배달비 ${recentlyResult.deliveryFee}원"
            if (recentlyResult.deliveryFee == "무료"){
                tempStringDeliveryCost = "무료배달"
            }
            deliveryCost.text = tempStringDeliveryCost


            Glide.with(image.context)
                .load(recentlyResult.repRestImageUrl)
                .into(image)
            // image.setImageResource(R.drawable.restaurant_famous) //일단 이미지 더미로
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
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_famous,parent,false)
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