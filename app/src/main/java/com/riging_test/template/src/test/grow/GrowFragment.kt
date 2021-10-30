package com.riging_test.template.src.test.grow

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentGrowBinding

class GrowFragment: BaseFragment<FragmentGrowBinding>(FragmentGrowBinding::bind, R.layout.fragment_grow){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            var Data= requireArguments().getString("Data")
            binding.GrowText.text=Data
        }

    }
}