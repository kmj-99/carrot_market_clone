package com.riging_test.template.src.main._1home

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.riging_test.template.R
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityHomeFloatButtonBacgroundBinding
import com.riging_test.template.databinding.ActivityMainBinding

class HomeCustomDialog: BaseActivity<ActivityHomeFloatButtonBacgroundBinding>(ActivityHomeFloatButtonBacgroundBinding::inflate){
    private var Close=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_float_button_bacground)

        var fab_open= AnimationUtils.loadAnimation(this,R.anim.fab_open)
        var fab_close= AnimationUtils.loadAnimation(this,R.anim.fab_close)

        var button1=findViewById<View>(R.id.home_button_plus)
        var button2=findViewById<View>(R.id.home_button_marketing)
        var button3=findViewById<View>(R.id.home_button_posting)

        button1.setOnClickListener {
            Toast.makeText(this,"afesw",Toast.LENGTH_LONG)
            if(Close) {
                button2.startAnimation(fab_open)
                button3.startAnimation(fab_open)

                Close=false
            }else{
                button2.startAnimation(fab_close)
                button3.startAnimation(fab_close)

                Close=true
            }
        }



    }
}