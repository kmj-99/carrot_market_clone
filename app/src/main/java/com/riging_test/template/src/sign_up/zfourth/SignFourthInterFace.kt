package com.riging_test.template.src.sign_up.zfourth

import com.riging_test.template.src.sign_up.third.models.PostSignUpRequest
import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import com.riging_test.template.src.sign_up.zfourth.models.PostNewSignupRequest
import com.riging_test.template.src.sign_up.zfourth.models.SignupResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignFourthInterFace {

    @POST("users")
    fun postNewSignUp(@Body parms:PostNewSignupRequest): Call<SignupResponse>

}