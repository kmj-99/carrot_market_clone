package com.riging_test.template.src.app_start

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityStartBinding
import com.riging_test.template.src.sign_up.SignActivity

class StartActivity : BaseActivity<ActivityStartBinding>(ActivityStartBinding::inflate) {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onStart() {
        super.onStart()

        StatusColor()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences("login", MODE_PRIVATE)



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