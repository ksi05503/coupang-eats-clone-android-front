package com.example.risingtest.src.main.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingtest.R
import com.example.risingtest.src.main.search.models.SearchKewordResult

class SearchKeywordAdapter : RecyclerView.Adapter<SearchKeywordAdapter.ViewHolder>() {
    var dataSet = listOf<SearchKewordResult>()

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){

        val word: TextView = view.findViewById(R.id.item_recent_keyword_word)
        val day: TextView = view.findViewById(R.id.item_recent_keyword_day)


        fun setItemInfo(searchKewordResult: SearchKewordResult){
            word.text = searchKewordResult.searchContent
            day.text = searchKewordResult.date

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_search_recent_keyword,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataSet.get(position)
        holder.setItemInfo(data)
        //누르면 data의 word로 검색 액티비티로 이동

        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, SubSearchActivity::class.java)
            i.putExtra("keyword","떡볶이")
            holder.itemView.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}