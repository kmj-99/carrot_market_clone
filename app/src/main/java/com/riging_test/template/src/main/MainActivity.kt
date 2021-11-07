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

        var nickName=intent.getStringExtra("NickName")
        var phoneNumber=intent.getStringExtra("PhoneNumber")
        var location=intent.getStringExtra("Location")
        var profile_Image=storageRef.child("profile_image/profile1").toString()


        showCustomToast(nickName+phoneNumber+location+profile_Image)



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
                        if(send) {
                            var bundle = Bundle()
                            bundle.putString("NickName", nickName)
                            bundle.putString("PhoneNumber", phoneNumber)
                            bundle.putString("Location", location)
                            bundle.putString("ProfileImage", profile_Image)

                            myCarrotFragment = MyCarrotFragment()
                            myCarrotFragment.arguments = bundle
                            send=true
                        }

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_container, myCarrotFragment)
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