package com.example.risingtest.src.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.cart.models.RestAdditionalMenuResult


class DetailMenuAdapter : RecyclerView.Adapter<DetailMenuAdapter.ViewHolder>()  {
    var dataSet = listOf<RestAdditionalMenuResult>()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nameView : TextView = view.findViewById(R.id.item_additional_menu_name)
        val chargeView : TextView = view.findViewById(R.id.item_additional_menu_charge)

        fun setItemInfo(restAdditionalMenuResult: RestAdditionalMenuResult){
            //val menuTempText = restAdditionalMenuResult.additionalMenuContents.split("+")[0].split("(")[0]
            //nameView.text = restAdditionalMenuResult.additionalMenuContents
            nameView.text = restAdditionalMenuResult.additionalMenuContents.split("+")[0].split("(")[0]
            if(restAdditionalMenuResult.additionalMenuPrice ==0 ){
                chargeView.visibility =View.GONE
            }else{
                chargeView.text = "(+${restAdditionalMenuResult.additionalMenuPrice}원)"
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail_menu,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailMenuAdapter.ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }



}