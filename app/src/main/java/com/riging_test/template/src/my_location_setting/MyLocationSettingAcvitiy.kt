package com.riging_test.template.src.my_location_setting

import android.os.Bundle
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMyLocationSettingBinding
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams




class MyLocationSettingAcvitiy: BaseActivity<ActivityMyLocationSettingBinding>(ActivityMyLocationSettingBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.myLocationSeekbar.setOnSeekChangeListener(object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams) {

            }

            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar) {}
            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar) {}
        })
    }
}