package com.riging_test.template.src.home_category

import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityHomeCategoryBinding

class HomeCategoryActivity: BaseActivity<ActivityHomeCategoryBinding>(ActivityHomeCategoryBinding::inflate) {

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}