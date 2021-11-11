package com.riging_test.template.src.main._5my_carrot

import com.riging_test.template.src.main._5my_carrot.model.UserInfoResponse

interface MyCarrotFragmentView {

    fun getUserInfoSuccess(response: UserInfoResponse)
    fun getUserInfoFailure(message:String)

}