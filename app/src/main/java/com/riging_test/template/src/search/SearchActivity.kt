package com.riging_test.template.src.search

import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivitySearchBinding
import com.riging_test.template.databinding.ActivitySignupBinding
import javax.net.ssl.SSLEngineResult

class SearchActivity: BaseActivity<ActivitySearchBinding>(ActivitySearchBinding::inflate) {

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}