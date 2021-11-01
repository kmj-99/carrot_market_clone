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
import android.view.Menu as Menu

class MainActivity :BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var menu:Menu

    override fun onStart() {
        super.onStart()

        StatusColor()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, HomeFragment())
            .commitAllowingStateLoss()

        menu=binding.mainBottombar.getMenu();


        binding.mainBottombar.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener{ item->
                when(item.itemId){

                    R.id.menu_main_button_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, HomeFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.select_home)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.select_no_life)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.select_no_around)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.select_no_chat)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.select_no_my_carrot)


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

                        item.setIcon(R.drawable.select_life)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.select_no_home)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.select_no_around)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.select_no_chat)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.select_no_my_carrot)

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_around -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, AroundFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.select_around)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.select_no_home)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.select_no_life)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.select_no_chat)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.select_no_my_carrot)

                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.menu_main_button_chat -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, ChatFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.select_chat)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.select_no_home)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.select_no_life)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.select_no_around)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.select_no_my_carrot)

                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.menu_main_button_my_carrot -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, MyCarrotFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.select_my_carrot)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.select_no_home)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.select_no_life)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.select_no_around)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.select_no_chat)

                        return@OnNavigationItemSelectedListener true

                    }

                }
                false
            }
        )


    }
}