package com.riging_test.template.src.app_start

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.app_start.models.CertificationReponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AppStartService(val view:AppStartFragmentView) {

    fun TryGetCertification(jwt:String){
        val certificationRetrofitInterface= ApplicationClass.sRetrofit.create(
            AppStartInterface::class.java)
        certificationRetrofitInterface.getJwtCertification(jwt).enqueue(object:
            Callback<CertificationReponse> {
            override fun onResponse(
                call: Call<CertificationReponse>,
                response: Response<CertificationReponse>
            ) {
                if(response.body()!=null){
                    view.getCertificationSuccess(response.body() as CertificationReponse)
                }


            }
            override fun onFailure(call: Call<CertificationReponse>, t: Throwable) {
                view.getCertificationFailure(t.message?:"통신오류")

            }

        })

    }




}