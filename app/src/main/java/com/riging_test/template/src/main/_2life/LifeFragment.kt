package com.riging_test.template.src.main._2life

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentHomeBinding
import com.riging_test.template.databinding.FragmentLifeBinding

class LifeFragment: BaseFragment<FragmentLifeBinding>(FragmentLifeBinding::bind, R.layout.fragment_life) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}