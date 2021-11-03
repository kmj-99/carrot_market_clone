package com.riging_test.template.src.sign_up.third

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.sign_up.third.models.PostSignUpRequest
import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignThirdService (val view:SignThirdFragmentView){

    fun PostCertification(postSignUpRequest:PostSignUpRequest){
        val signThirdRetrofitInterface=ApplicationClass.sRetrofit.create(SignThirdRetrofitInterface::class.java)
        signThirdRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object:Callback<PostSignUpResponse>{
            override fun onResponse(
                call: Call<PostSignUpResponse>,
                response: Response<PostSignUpResponse>
            ) {
                view.onPostCertificationSuccess(response.body() as PostSignUpResponse)
            }

            override fun onFailure(call: Call<PostSignUpResponse>, t: Throwable) {
                view.onPostCertificationFailure(t.message ?: "통신 오류")
            }

        })

    }
}