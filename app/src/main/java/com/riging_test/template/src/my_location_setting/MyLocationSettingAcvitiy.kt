package com.riging_test.template.src.my_location_setting

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.config.ApplicationClass.Companion.sSharedPreferences
import com.riging_test.template.config.BaseActivity
import com.riging_test.template.databinding.ActivityMyLocationSettingBinding
import com.riging_test.template.src.my_location_setting.models.AroundTownResponse
import com.riging_test.template.src.my_location_setting.models.ChangeResponse
import com.warkiz.widget.IndicatorSeekBar
import com.warkiz.widget.OnSeekChangeListener
import com.warkiz.widget.SeekParams




class MyLocationSettingAcvitiy: BaseActivity<ActivityMyLocationSettingBinding>
    (ActivityMyLocationSettingBinding::inflate),MyLocationSettingView {

    private var range=0
    private var view=this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.myLocationSeekbar.setOnSeekChangeListener(object : OnSeekChangeListener {
            override fun onSeeking(seekParams: SeekParams) {
                range=seekParams.thumbPosition
                MyLocationSettingService(view).TryGetAroundTown(1665)

            }

            override fun onStartTrackingTouch(seekBar: IndicatorSeekBar) {

            }
            override fun onStopTrackingTouch(seekBar: IndicatorSeekBar) {

            }
        })

        binding.myLocationSettingBack.setOnClickListener {
            MyLocationSettingService(this).TryPatchChangeRange(sSharedPreferences.getString("jwt","1")!!,1665,range)
            finish()
        }
    }
    @SuppressLint("SetTextI18n")
    override fun onAroundTownSuccess(response: AroundTownResponse) {
        if(response.code==1000){
            when(range){
                0 -> {
                    binding.myLocationSettingTextAroundLocation.text="근처 동네 ${response.result.range1.size} 개"

                }
                1 -> {
                    binding.myLocationSettingTextAroundLocation.text="근처 동네 ${response.result.range2.size} 개"

                }

                2 -> {
                    binding.myLocationSettingTextAroundLocation.text="근처 동네 ${response.result.range3.size} 개"

                }

                3 -> {
                    binding.myLocationSettingTextAroundLocation.text="근처 동네 ${response.result.range4.size} 개"

                }
            }
        }else{
            showCustomToast(response.code.toString())
        }
    }

    override fun onAroundTownFailure(message: String) {
        showCustomToast(message)
    }

    override fun onChangeRangeSuccess(response: ChangeResponse) {
        if(response.code==1000){
            showCustomToast(response.message)
        }else{
            showCustomToast(response.message)
        }
    }

    override fun onChangeRangeFailure(message: String) {
        showCustomToast(message)
    }
}