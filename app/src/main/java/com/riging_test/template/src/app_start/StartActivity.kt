package com.riging_test.template.src.app_start

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMainBinding
import com.riging_test.template.databinding.ActivityStartBinding
import com.riging_test.template.src.sign_up.SignActivity
import com.riging_test.template.src.test.MainActivity

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate) {

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Thread {
            Thread.sleep(3000)
            var Main_Intent = Intent(applicationContext, SignActivity::class.java)

            startActivity(Main_Intent)
            finish()
        }.start()

    }

    override fun onResume() {
        super.onResume()



    }
}