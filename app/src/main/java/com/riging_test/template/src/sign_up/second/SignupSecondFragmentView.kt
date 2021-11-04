package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.ArroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.LocationResponse

interface SignupSecondFragmentView {

    fun TryGetLocationSuccess(response:LocationResponse)
    fun TryGetLocationFailue(message:String)

    fun TryGetAroundLocationSuccss(response: ArroundLocationResponse)
    fun TryGetAroundLocationFailue(message:String)


}

