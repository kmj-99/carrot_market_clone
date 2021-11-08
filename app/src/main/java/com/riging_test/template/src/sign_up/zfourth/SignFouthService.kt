package com.riging_test.template.src.sign_up.zfourth

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.sign_up.third.models.PostSignUpRequest
import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import com.riging_test.template.src.sign_up.zfourth.models.PostNewSignupRequest
import com.riging_test.template.src.sign_up.zfourth.models.SignupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignFouthService (val view:SignFouthFragmentView){

    fun PostSignup(postNewSignupRequest:PostNewSignupRequest){
        val SignupFourthRetrofitInterface=ApplicationClass.sRetrofit.create(SignFourthInterFace::class.java)
        SignupFourthRetrofitInterface.postNewSignUp(postNewSignupRequest).enqueue(object:Callback<SignupResponse>{
            override fun onResponse(
                call: Call<SignupResponse>,
                response: Response<SignupResponse>
            ) {
                view.onPostSignupSuccess(response.body() as SignupResponse)
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                view.onPostSignupFailure(t.message ?: "통신 오류")
            }

        })

    }
}