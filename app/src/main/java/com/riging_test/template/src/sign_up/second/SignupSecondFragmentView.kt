package com.riging_test.template.src.sign_up.second

import com.riging_test.template.src.sign_up.second.models.AroundLocationResponse
import com.riging_test.template.src.sign_up.second.models.ArroundLocationTownId
import com.riging_test.template.src.sign_up.second.models.LocationResponse

interface SignupSecondFragmentView {

    fun TryGetLocationSuccess(response:LocationResponse)
    fun TryGetLocationFailue(message:String)

    fun TryGetTownIdSuccss(response: ArroundLocationTownId)
    fun TryGetTownFailue(message:String)

    fun TryGetAroundLocationSuccss(response: AroundLocationResponse)
    fun TryGetAroundLocationFailue(message: String)


}

