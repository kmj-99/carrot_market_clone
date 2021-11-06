package com.riging_test.template.src.main._5my_carrot

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.databinding.FragmentMyCarrotBinding
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotAdapter
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotDataClass
import com.riging_test.template.src.main._5my_carrot.Rv.MyCarrotViewType
import kotlinx.android.synthetic.main.fragment_signup_second.*

class MyCarrotFragment : BaseFragment<FragmentMyCarrotBinding>(FragmentMyCarrotBinding::bind, R.layout.fragment_my_carrot){
    private var TestList=ArrayList<MyCarrotDataClass>()
    private var TestList2=ArrayList<MyCarrotDataClass>()
    private var TestList3=ArrayList<MyCarrotDataClass>()
    private var TestList4=ArrayList<MyCarrotDataClass>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for(i in 0..5){
            TestList.add(MyCarrotDataClass(R.drawable.certification_image,"Content1 $i"))
        }

        binding.myCarrotRv1.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv1.adapter=MyCarrotAdapter(requireContext(),TestList)

        for(i in 0..5){
            TestList2.add(MyCarrotDataClass(R.drawable.carrot_image,"Content2 $i"))
        }

        binding.myCarrotRv2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv2.adapter=MyCarrotAdapter(requireContext(),TestList2)
        for(i in 0..5){
            TestList3.add(MyCarrotDataClass(R.drawable.document_image,"Content3 $i"))
        }

        binding.myCarrotRv3.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv3.adapter=MyCarrotAdapter(requireContext(),TestList3)
        for(i in 0..5){
            TestList4.add(MyCarrotDataClass(R.drawable.share_icon,"Content4 $i"))
        }

        binding.myCarrotRv4.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.myCarrotRv4.adapter=MyCarrotAdapter(requireContext(),TestList4)


        binding.myCarrotLayoutProfile.setOnClickListener {

        }

    }
}