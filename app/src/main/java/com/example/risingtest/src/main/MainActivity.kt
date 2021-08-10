package com.example.risingtest.src.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.R
import com.example.risingtest.config.ApplicationClass
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityMainBinding
import com.example.risingtest.src.main.favorites.FavoritesActivity
import com.example.risingtest.src.main.favorites.FavoritesFragment
import com.example.risingtest.src.main.home.HomeFragment
import com.example.risingtest.src.main.myeats.MyEatsFragment
import com.example.risingtest.src.main.orders.OrdersFragment
import com.example.risingtest.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commitAllowingStateLoss()
        binding.mainBtmNav.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_btm_nav_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_favorites -> {
/*                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, FavoritesFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true*/

                        val i = Intent(this,FavoritesActivity::class.java)
                        startActivity(i)

                    }
                    R.id.menu_main_btm_nav_orders -> {

                        if(checkIsLogin()){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, OrdersFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }else{
                            //bottom sheet 로그인 다이얼로그 띄우기
                            val bottomSheet = BottomSheet(0)
                            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
                        }

                    }
                    R.id.menu_main_btm_nav_my_eats -> {

                        if(checkIsLogin()){
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.main_frm, MyEatsFragment())
                                .commitAllowingStateLoss()
                            return@OnNavigationItemSelectedListener true
                        }else{
                            //bottom sheet 로그인 다이얼로그 띄우기
                            val bottomSheet = BottomSheet(0)
                            bottomSheet.show(supportFragmentManager, bottomSheet.tag)

                        }



                    }

                }
                false
            })
    }

}