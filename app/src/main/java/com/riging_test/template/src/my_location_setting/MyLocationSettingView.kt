package com.riging_test.template.src.my_location_setting

import com.riging_test.template.src.my_location_setting.models.AroundTownResponse
import com.riging_test.template.src.my_location_setting.models.ChangeResponse

interface MyLocationSettingView {

    fun onAroundTownSuccess(response:AroundTownResponse)
    fun onAroundTownFailure(message:String)

    fun onChangeRangeSuccess(response:ChangeResponse)
    fun onChangeRangeFailure(message:String)
}