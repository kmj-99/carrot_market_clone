package com.riging_test.template.src.sign_up.zfourth

import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import com.riging_test.template.src.sign_up.zfourth.models.SignupResponse

interface SignFouthFragmentView {
    fun onPostSignupSuccess(response:SignupResponse)
    fun onPostSignupFailure(message:String)
}