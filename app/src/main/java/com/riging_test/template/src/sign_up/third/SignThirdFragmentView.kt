package com.riging_test.template.src.sign_up.third

import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse

interface SignThirdFragmentView {
    fun onPostCertificationSuccess(response:PostSignUpResponse)
    fun onPostCertificationFailure(message:String)
}