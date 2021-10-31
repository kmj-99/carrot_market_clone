package com.riging_test.template.src.main._5my_carrot

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.databinding.FragmentMyCarrotBinding

class MyCarrotFragment : BaseFragment<FragmentMyCarrotBinding>(FragmentMyCarrotBinding::bind, R.layout.fragment_my_carrot){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}