package com.example.risingtest.src.main.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.RestaurantProfileData
import com.example.risingtest.src.main.home.models.HomeRestResult
import com.example.risingtest.src.main.restaurant.RestaurantActivity

class RestaurantProfileAdapter: RecyclerView.Adapter<RestaurantProfileAdapter.ViewHolder>() {

    var dataSet = listOf<HomeRestResult>()


    class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.item_image_view_restaurant_image)
        val textViewName : TextView = view.findViewById(R.id.item_text_restaurant_name)
        val imageViewStar: ImageView = view.findViewById(R.id.item_image_view_star)
        val textViewGrade : TextView = view.findViewById(R.id.item_text_restaurant_grade)
        val textViewReviewCount : TextView = view.findViewById(R.id.item_text_restaurant_review_count)
        val textViewDistance : TextView = view.findViewById(R.id.item_text_restaurant_distance)
        val textViewCharge : TextView = view.findViewById(R.id.item_text_restaurant_charge)

        fun setItemInfo(homeRestResult: HomeRestResult){

            if(homeRestResult.count_review == 0){
                textViewGrade.visibility = View.GONE
                imageViewStar.visibility = View.GONE
                textViewReviewCount.visibility = View.GONE
            }else{
                textViewGrade.visibility = View.VISIBLE
                imageViewStar.visibility = View.VISIBLE
                textViewReviewCount.visibility = View.VISIBLE
            }

            imageView.setImageResource(R.drawable.restaurant_image_2) //임시

            textViewName.text = homeRestResult.restName
            textViewGrade.text = homeRestResult.star.toString()
            textViewReviewCount.text = "(${homeRestResult.count_review})"
            textViewDistance.text ="${homeRestResult.distance_KM}km"
            if(homeRestResult.deliveryFee == "무료")
                textViewCharge.text = "무료배달"
            else
                textViewCharge.text = homeRestResult.deliveryFee

        }

        init {
            view.setOnClickListener {
                Log.d("RProfile recyclerView","뷰 눌렸습니다.")
                //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
                val i = Intent(view.context, RestaurantActivity::class.java)
                view.context.startActivity(i)

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantProfileAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_profile,parent,false)
        return RestaurantProfileAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantProfileAdapter.ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}