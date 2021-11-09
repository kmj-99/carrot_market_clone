package com.riging_test.template.src.my_favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyFarvoriteConnectViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {



    var FragmentList=ArrayList<Fragment>()


    override fun getItemCount(): Int {
        return FragmentList.size
    }

    override fun createFragment(position: Int): Fragment {

        return FragmentList[position]
    }
    fun addFragment(fragments:ArrayList<Fragment>){
        this.FragmentList=fragments
    }

}