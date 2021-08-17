package com.example.risingtest.src.main.franchises

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityFranchisesBinding
import com.example.risingtest.src.main.franchises.models.FranchisesResponse
import com.example.risingtest.src.main.franchises.models.FranchisesResult
import com.example.risingtest.src.main.search.SearchActivity

class FranchisesActivity : BaseActivity<ActivityFranchisesBinding>(ActivityFranchisesBinding::inflate), FranchisesActivityView {
    val extraDataListCheetah = mutableListOf<FranchisesResult>()
    var extraDataListNonCheetah = mutableListOf<FranchisesResult>()
    private val filterArray = arrayOf(false,false,false,false,false)
    val adapter = RestaurantFranchisesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FranchisesService(this).tryGetFranchises(1,"N",100000,100000)

        binding.franchisesSearchBtn.setOnClickListener {
            val i= Intent(this, SearchActivity::class.java)
            startActivity(i)
        }

        initFilter()

    }

    private fun initFilter() {

        binding.apply {


            val white_int = Color.parseColor("#FFFFFFFF")
            val lightblue_int = Color.parseColor("#00A6FF")
            val black_int = Color.parseColor("#FF000000")
            franchisesLayoutCheetah.setOnClickListener {  //filterArray[1]
                if (filterArray[1] == false) {
                    franchisesLayoutCheetah.setBackgroundResource(R.drawable.border_shape_selected)
                    franchisesTextCheetah.setTextColor(white_int)

                    adapter.dataSet = extraDataListCheetah
                    adapter.notifyDataSetChanged()
                } else {
                    franchisesLayoutCheetah.setBackgroundResource(R.drawable.border_shape_2)
                    franchisesTextCheetah.setTextColor(black_int)

                    adapter.dataSet = extraDataListNonCheetah
                    adapter.notifyDataSetChanged()
                }
                filterArray[1] = !filterArray[1]
            }
        }
    }
    override fun onGetFranchisesSuccess(response: FranchisesResponse) {
        Log.d("Okhttp",response.result.size.toString())
         adapter.dataSet = response.result
         binding.recyclerViewFranchisesRestaurant.adapter = adapter

        extraDataListNonCheetah = response.result.toMutableList()
        val size = response.result.size
        if(size > 3 ){
            for(i in 1..3){
                extraDataListCheetah.add(response.result[size-i])
            }
        }

    }

    override fun onGetFranchisesFailure(message: String) {
        Log.d("Okhttp", message)
    }


}