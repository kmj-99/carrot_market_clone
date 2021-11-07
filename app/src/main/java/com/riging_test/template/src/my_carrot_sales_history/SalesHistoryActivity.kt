package com.riging_test.template.src.my_carrot_sales_history

import android.os.Bundle
import androidx.annotation.Px
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivitySalesHistoryBinding
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.HistoryFragment1
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.HistoryFragment2
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.HistoryFragment3

class SalesHistoryActivity: BaseActivity<ActivitySalesHistoryBinding>(ActivitySalesHistoryBinding::inflate) {
    private var FragmentList=ArrayList<Fragment>()


    override fun onStart() {
        super.onStart()
        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FragmentList.add(HistoryFragment1())
        FragmentList.add(HistoryFragment2())
        FragmentList.add(HistoryFragment3())


        var View_Pager=binding.salesHistoryViewPager
        var ViewPager_Fragment_Adapter= SalesHistoryConnectViewPagerAdapter(this)

        ViewPager_Fragment_Adapter.addFragment(FragmentList)
        View_Pager.adapter=ViewPager_Fragment_Adapter


        binding.salesHistoryTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
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
                binding.salesHistoryTabLayout.setScrollPosition(position,0f,true)
                showCustomToast("$position")
            }

            override fun onPageScrollStateChanged(@ViewPager2.ScrollState state: Int) {}

        })





    }
}