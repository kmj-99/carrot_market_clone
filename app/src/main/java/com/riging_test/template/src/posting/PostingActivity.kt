package com.riging_test.template.src.posting

import android.os.Bundle
import android.view.ViewTreeObserver
import android.view.WindowManager
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityPostingBinding
import com.riging_test.template.databinding.ActivityProductDealBinding

class PostingActivity: BaseActivity<ActivityPostingBinding>(ActivityPostingBinding::inflate) {
    override fun onStart() {
        super.onStart()
        StatusColor()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

}