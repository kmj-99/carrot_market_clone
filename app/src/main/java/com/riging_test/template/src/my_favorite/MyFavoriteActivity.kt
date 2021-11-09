package com.riging_test.template.src.my_favorite

import android.os.Bundle
import androidx.annotation.Px
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMyFavoriteBinding
import com.riging_test.template.src.my_carrot_sales_history.SalesHistoryConnectViewPagerAdapter
import com.riging_test.template.src.my_favorite.fragment.fragment1.MyFavoriteFragment1
import com.riging_test.template.src.my_favorite.fragment.MyFavoriteFragment2
import com.riging_test.template.src.my_favorite.fragment.MyFavoriteFragment3

class MyFavoriteActivity: BaseActivity<ActivityMyFavoriteBinding>(ActivityMyFavoriteBinding::inflate) {
    private var FragmentList=ArrayList<Fragment>()

    override fun onStart() {
        super.onStart()
        StatusColor()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FragmentList.add(MyFavoriteFragment1())
        FragmentList.add(MyFavoriteFragment2())
        FragmentList.add(MyFavoriteFragment3())



        var View_Pager=binding.myFavoriteViewPager
        var ViewPager_Fragment_Adapter= SalesHistoryConnectViewPagerAdapter(this)

        ViewPager_Fragment_Adapter.addFragment(FragmentList)
        View_Pager.adapter=ViewPager_Fragment_Adapter


        binding.myFavoriteTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                    1 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                    2 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                    3 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                return
            }

        })



        View_Pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int, positionOffset: Float,
                @Px positionOffsetPixels: Int
            ) {
            }
            //뷰페이저가 변할때마다 탭 레이아웃의 포지션이 바뀌도록 설정
            override fun onPageSelected(position: Int) {
                binding.myFavoriteTabLayout.setScrollPosition(position,0f,true)
                showCustomToast("$position")
            }

            override fun onPageScrollStateChanged(@ViewPager2.ScrollState state: Int) {}

        })




    }
}