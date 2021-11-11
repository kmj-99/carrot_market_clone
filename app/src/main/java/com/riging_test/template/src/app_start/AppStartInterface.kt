package com.riging_test.template.src.app_start

import com.riging_test.template.src.app_start.models.CertificationReponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface AppStartInterface {

    @GET("users/logIn/jwt")
    fun getJwtCertification(@Header("X-ACCESS-TOKEN")jwt:String
    ):Call<CertificationReponse>
}