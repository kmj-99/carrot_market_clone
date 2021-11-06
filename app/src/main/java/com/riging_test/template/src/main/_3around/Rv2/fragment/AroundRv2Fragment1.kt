package com.riging_test.template.src.main._3around.Rv2.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentViewpager1Binding
import com.riging_test.template.src.main._3around.Rv2.fragment.Rv.AroundRv2FragmentAdapter
import com.riging_test.template.src.main._3around.Rv2.fragment.Rv.AroundRv2FragmentDataClass

class AroundRv2Fragment1: BaseFragment<FragmentViewpager1Binding>(FragmentViewpager1Binding::bind, R.layout.fragment_viewpager1) {
    private var RvItemList=ArrayList<AroundRv2FragmentDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0..2){
            RvItemList.add(
                AroundRv2FragmentDataClass(R.drawable.test_image,"록키의 드링크$i","오들오들 추운 날 따뜻하게\n 즐겨도 맛있는 트리흘 헬스 드링크",
                                                        "록키헬스점$i","진접읍"))
        }

        binding.viewpagerFragment1Rv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.viewpagerFragment1Rv.adapter=AroundRv2FragmentAdapter(requireContext(),RvItemList)
    }


}