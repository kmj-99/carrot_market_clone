package com.riging_test.template.src.app_start

import com.riging_test.template.src.app_start.models.CertificationReponse

interface AppStartFragmentView {

    fun getCertificationSuccess(response: CertificationReponse)
    fun getCertificationFailure(message:String)
}