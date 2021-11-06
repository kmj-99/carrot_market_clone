package com.riging_test.template.src.main._3around

import android.os.Bundle
import android.view.View
import androidx.annotation.Px
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.ScrollState
import com.google.android.material.tabs.TabLayout
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentAroundBinding
import com.riging_test.template.src.main._3around.Rv1.AroundRv1Adapter
import com.riging_test.template.src.main._3around.Rv1.AroundRv1Dataclass
import com.riging_test.template.src.main._3around.Rv2.AroundConnectViewPagerAdapter
import com.riging_test.template.src.main._3around.Rv2.AroundRv2Adapter
import com.riging_test.template.src.main._3around.Rv2.AroundRv2Dataclass
import com.riging_test.template.src.main._3around.Rv2.fragment.*
import com.riging_test.template.src.main._3around.Rv3.AroundRv3Adapter
import com.riging_test.template.src.main._3around.Rv3.AroundRv3DataClass
import com.riging_test.template.src.main._3around.Rv4.AroundRv4Adapter
import com.riging_test.template.src.main._3around.Rv4.AroundRv4DataClass

class AroundFragment : BaseFragment<FragmentAroundBinding>(FragmentAroundBinding::bind, R.layout.fragment_around){
    private var Rv1List=ArrayList<AroundRv1Dataclass>()
    private var Rv2List=ArrayList<AroundRv2Dataclass>()
    private var Rv3List=ArrayList<AroundRv3DataClass>()
    private var Rv4List=ArrayList<AroundRv4DataClass>()
    private var FragmentList=ArrayList<Fragment>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0..5){
            Rv1List.add(AroundRv1Dataclass("록키$i"))
        }
        binding.aroundRv1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.aroundRv1.adapter=AroundRv1Adapter(Rv1List)


        for(i in 0..5){
            Rv2List.add(AroundRv2Dataclass(R.drawable.category_star_icon,"록키$i"))

        }

        binding.aroundRv2.layoutManager=GridLayoutManager(requireContext(),4,LinearLayoutManager.VERTICAL,false)
        binding.aroundRv2.adapter=AroundRv2Adapter(requireContext(),Rv2List)

        FragmentList.add(AroundRv2Fragment1())
        FragmentList.add(AroundRv2Fragment2())
        FragmentList.add(AroundRv2Fragment3())
        FragmentList.add(AroundRv2Fragment4())
        FragmentList.add(AroundRv2Fragment5())
        FragmentList.add(AroundRv2Fragment6())
        FragmentList.add(AroundRv2Fragment7())

        var View_Pager=binding.aroundViewPager
        var ViewPager_Fragment_Adapter=AroundConnectViewPagerAdapter(requireActivity())

        ViewPager_Fragment_Adapter.addFragment(FragmentList)
        View_Pager.adapter=ViewPager_Fragment_Adapter

        binding.aroundTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
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

                    4 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                    5 -> {
                        View_Pager.setCurrentItem(tab?.position)
                    }

                    6 -> {
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
        View_Pager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int, positionOffset: Float,
                @Px positionOffsetPixels: Int
            ) {
            }
            //뷰페이저가 변할때마다 탭 레이아웃의 포지션이 바뀌도록 설정
            override fun onPageSelected(position: Int) {
                binding.aroundTabLayout.setScrollPosition(position,0f,true)
             showCustomToast("$position")
            }

            override fun onPageScrollStateChanged(@ScrollState state: Int) {}

        })


        for(i in 0..5){
            Rv3List.add(
                AroundRv3DataClass(R.drawable.test_image,"맘케이크","기신면","올드릿지 10% 할인쿠폰",
                                          R.drawable.profile_image,R.drawable.profile_image,R.drawable.profile_image,
                                         "외 180명이 받았아요","딱딱하지 않고 부드러운게 넘 맛나요"))
        }

        binding.aroundRv3.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.aroundRv3.adapter=AroundRv3Adapter(requireContext(),Rv3List)


        for(i in 0..5){
            Rv4List.add(AroundRv4DataClass(R.drawable.test_image,R.drawable.test_image,"궁사부","하루 2-3마리의 슈페리얼 등급 연어를..",
                                            "8","187","쇼핑퀸미세스초이 아이들이 우동을 좋\n아하는데 우동국물이 깔끔하고.."))
        }
        binding.aroundRv4.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        binding.aroundRv4.adapter=AroundRv4Adapter(requireContext(),Rv4List)



    }
}