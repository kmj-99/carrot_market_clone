package com.riging_test.template.src.test

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMainBinding
import com.riging_test.template.databinding.TestActivityMainBinding
import com.riging_test.template.src.test.grow.GrowFragment
import com.riging_test.template.src.test.image_search.ImageSearchFragment
import com.riging_test.template.src.test.search.SearchFragment

class TestMainActivity :BaseActivity<TestActivityMainBinding>(TestActivityMainBinding::inflate){
    private lateinit var translateLeftAnim:Animation
    private lateinit var translateRightAnim:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //상태바 투명하게 만드는 코드
        window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT

        translateLeftAnim=AnimationUtils.loadAnimation(this,R.anim.translate_left)
        translateRightAnim=AnimationUtils.loadAnimation(this,R.anim.translate_right)

        var page=binding.mainFragment

        supportFragmentManager.beginTransaction().replace(R.id.main_fragment,SearchFragment()).commitAllowingStateLoss()
        binding.BottomBar.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener{item->
                when(item.itemId){

                    R.id.menu_main_button_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment, SearchFragment())
                            .commitAllowingStateLoss()
                        page.startAnimation(translateLeftAnim)

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_grow -> {
                        var grow_fragment=GrowFragment()
                        var bundle=Bundle()
                        bundle.putString("Data","hello")
                        grow_fragment.arguments=bundle
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment,grow_fragment)
                            .commitAllowingStateLoss()
                        page.startAnimation(translateLeftAnim)

                        return@OnNavigationItemSelectedListener true

                    }

                    R.id.menu_main_button_image_search -> {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment,ImageSearchFragment())
                            .commitAllowingStateLoss()
                        page.startAnimation(translateLeftAnim)


                        return@OnNavigationItemSelectedListener true

                    }

                }
                    false
            }
        )


    }
}