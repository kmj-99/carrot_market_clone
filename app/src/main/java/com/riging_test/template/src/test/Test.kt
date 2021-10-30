package com.riging_test.template.src.test

import android.os.Bundle
import android.widget.Toast
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.TestBinding

class Test: BaseActivity<TestBinding>(TestBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            Toast.makeText(this,"esg",Toast.LENGTH_LONG).show()
    }
}