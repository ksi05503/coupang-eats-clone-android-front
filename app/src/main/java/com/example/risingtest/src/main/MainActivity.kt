package com.example.risingtest.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingtest.R
import com.example.risingtest.config.BaseActivity
import com.example.risingtest.databinding.ActivityMainBinding
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
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, FavoritesFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_orders -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, OrdersFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_btm_nav_my_eats -> {

                        //bottom sheet 로그인 다이얼로그 띄우기
                        val bottomSheet = BottomSheet()
                        bottomSheet.show(supportFragmentManager, bottomSheet.tag)


/*

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_frm, MyEatsFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true*/
                    }

                }
                false
            })
    }
}