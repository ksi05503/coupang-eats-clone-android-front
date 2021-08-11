package com.example.risingtest.src.main.home

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.risingtest.src.main.home.models.HomeRestResult
import com.example.risingtest.src.main.restaurant.RestaurantActivity

import com.bumptech.glide.request.RequestOptions


class RestaurantProfileAdapter: RecyclerView.Adapter<RestaurantProfileAdapter.ViewHolder>() {

    var dataSet = listOf<HomeRestResult>()


    class ViewHolder(view : View):RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(com.example.risingtest.R.id.item_image_view_restaurant_image)
        val textViewName : TextView = view.findViewById(com.example.risingtest.R.id.item_text_restaurant_name)
        val imageViewStar: ImageView = view.findViewById(com.example.risingtest.R.id.item_image_view_star)
        val textViewGrade : TextView = view.findViewById(com.example.risingtest.R.id.item_text_restaurant_grade)
        val textViewReviewCount : TextView = view.findViewById(com.example.risingtest.R.id.item_text_restaurant_review_count)
        val textViewDistance : TextView = view.findViewById(com.example.risingtest.R.id.item_text_restaurant_distance)
        val textViewCharge : TextView = view.findViewById(com.example.risingtest.R.id.item_text_restaurant_charge)

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

        //    imageView.setImageResource(R.drawable.restaurant_image_2) //임시


/*            Glide.with(imageView.context)
                .override(350, 350).centerCrop()
                .load(homeRestResult.repRestImageUrl)
                .into(imageView)*/
            Glide.with(imageView.context)
                .load(homeRestResult.repRestImageUrl)
                .apply(
                    RequestOptions().override(350, 350).centerCrop()
                )
                .into(imageView)


            textViewName.text = homeRestResult.restName
            textViewGrade.text = homeRestResult.star.toString()
            textViewReviewCount.text = "(${homeRestResult.count_review})"
            textViewDistance.text ="${homeRestResult.distance_KM}km"
            if(homeRestResult.deliveryFee == "무료")
                textViewCharge.text = "무료배달"
            else
                textViewCharge.text = "배달비 ${homeRestResult.deliveryFee}"

        }

        init {
/*            view.setOnClickListener {
                Log.d("RProfile recyclerView","뷰 눌렸습니다.")
                //어댑터에서 인텐트로 startActivity쏠때는 앞에 컨텍스트가 붙어야함(어댑터호출하는 상위액티비티)
                val i = Intent(view.context, RestaurantActivity::class.java)
                view.context.startActivity(i)

            }*/
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.risingtest.R.layout.item_restaurant_profile,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)

        holder.itemView.setOnClickListener {
            Log.d("RProfile recyclerView","뷰 눌렸습니다.")
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