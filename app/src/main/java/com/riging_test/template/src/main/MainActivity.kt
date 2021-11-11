package com.riging_test.template.src.main

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMainBinding
import com.riging_test.template.src.main._2life.LifeFragment
import com.riging_test.template.src.main._3around.AroundFragment
import com.riging_test.template.src.main._4chat.ChatFragment
import com.riging_test.template.src.main._5my_carrot.MyCarrotFragment
import com.riging_test.template.src.main._1home.HomeFragment
import com.riging_test.template.src.test.grow.GrowFragment
import android.view.Menu as Menu

class MainActivity :BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var menu:Menu

    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference

    private var myCarrotFragment=MyCarrotFragment()

    private var send=false

    override fun onStart() {
        super.onStart()

        StatusColor()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        storage= FirebaseStorage.getInstance("gs://riging-751d4.appspot.com")
        storageRef=storage.getReference()






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

                        item.setIcon(R.drawable.main_select_1_shape)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.main_select_no_2_shape)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.main_select_no_3_shape)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.main_select_no_4_shape)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.main_select_no_5_shape)


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

                        item.setIcon(R.drawable.main_select_2_shape)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.main_select_no_1_shape)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.main_select_no_3_shape)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.main_select_no_4_shape)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.main_select_no_5_shape)

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_around -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, AroundFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.main_select_3_shape)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.main_select_no_1_shape)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.main_select_no_2_shape)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.main_select_no_4_shape)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.main_select_no_5_shape)

                        return@OnNavigationItemSelectedListener true

                    }
                    R.id.menu_main_button_chat -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, ChatFragment())
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.main_select_4_shape)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.main_select_no_1_shape)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.main_select_no_2_shape)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.main_select_no_3_shape)
                        menu.findItem(R.id.menu_main_button_my_carrot).setIcon(R.drawable.main_select_no_5_shape)

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_my_carrot -> {
                        if(send) {
                            var bundle = Bundle()


                            myCarrotFragment = MyCarrotFragment()
                            myCarrotFragment.arguments = bundle
                            send=true
                        }

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, myCarrotFragment)
                            .commitAllowingStateLoss()

                        item.setIcon(R.drawable.main_select_5_shape)

                        menu.findItem(R.id.menu_main_button_home).setIcon(R.drawable.main_select_no_1_shape)
                        menu.findItem(R.id.menu_main_button_life).setIcon(R.drawable.main_select_no_2_shape)
                        menu.findItem(R.id.menu_main_button_around).setIcon(R.drawable.main_select_no_3_shape)
                        menu.findItem(R.id.menu_main_button_chat).setIcon(R.drawable.main_select_no_4_shape)

                        return@OnNavigationItemSelectedListener true

                    }

                }
                false
            }
        )


    }
}