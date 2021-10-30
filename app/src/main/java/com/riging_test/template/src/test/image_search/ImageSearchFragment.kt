package com.riging_test.template.src.test.image_search

import android.os.Bundle
import android.view.View
import com.riging_test.template.R
import com.riging_test.template.config.BaseFragment
import com.riging_test.template.databinding.FragmentImageSearchBinding

class ImageSearchFragment: BaseFragment<FragmentImageSearchBinding>(FragmentImageSearchBinding::bind,R.layout.fragment_image_search
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}