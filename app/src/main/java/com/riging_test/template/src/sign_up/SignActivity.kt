package com.riging_test.template.src.sign_up

import android.os.Bundle
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.*
import com.riging_test.template.src.sign_up.first.SignFirstFragment

class SignActivity:BaseActivity<ActivitySignupBinding>(ActivitySignupBinding::inflate) {

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            supportFragmentManager.beginTransaction()
                .replace(R.id.signup_layout, SignFirstFragment())
                .commitAllowingStateLoss()

    }



}