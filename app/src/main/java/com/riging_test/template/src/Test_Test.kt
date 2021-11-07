package com.riging_test.template.src

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.TestTestBinding

class Test_Test : BaseActivity<TestTestBinding>(TestTestBinding::inflate){
    private var up=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var anim=AnimationUtils.loadAnimation(this, R.anim.test_ani)
        var anim2=AnimationUtils.loadAnimation(this, R.anim.test_ani2)

        binding.testImage.setOnClickListener {
            if(up) {
                it.startAnimation(anim2)
                up=false
            }else{
                it.startAnimation(anim)
                up=true
            }
        }


    }

}