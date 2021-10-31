package com.riging_test.template.src.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMainBinding
import com.riging_test.template.src.main._2life.LifeFragment
import com.riging_test.template.src.main._3around.AroundFragment
import com.riging_test.template.src.main._4chat.ChatFragment
import com.riging_test.template.src.main._5my_carrot.MyCarrotFragment
import com.riging_test.template.src.main._home.HomeFragment
import com.riging_test.template.src.test.grow.GrowFragment
import com.riging_test.template.src.test.image_search.ImageSearchFragment
import com.riging_test.template.src.test.search.SearchFragment

class MainActivity :BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commitAllowingStateLoss()


        binding.mainBottombar.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener{ item->
                when(item.itemId){

                    R.id.menu_main_button_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, HomeFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_life -> {
                        var grow_fragment= GrowFragment()
                        var bundle=Bundle()
                        bundle.putString("Data","hello")
                        grow_fragment.arguments=bundle
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, LifeFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_around -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, AroundFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.menu_main_button_chat -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, ChatFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.menu_main_button_my_carrot -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, MyCarrotFragment())
                            .commitAllowingStateLoss()

                        return@OnNavigationItemSelectedListener true

                    }

                }
                false
            }
        )


    }
}