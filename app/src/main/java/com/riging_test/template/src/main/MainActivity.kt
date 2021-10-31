package com.riging_test.template.src.main

import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMainBinding

class MainActivity :BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}