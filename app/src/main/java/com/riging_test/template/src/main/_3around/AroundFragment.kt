package com.riging_test.template.src.main._3around

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentAroundBinding
import com.riging_test.template.databinding.FragmentHomeBinding

class AroundFragment : BaseFragment<FragmentAroundBinding>(FragmentAroundBinding::bind, R.layout.fragment_around){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}