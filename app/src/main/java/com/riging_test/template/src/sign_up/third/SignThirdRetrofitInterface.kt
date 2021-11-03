package com.riging_test.template.src.sign_up.third

import com.riging_test.template.src.sign_up.third.models.PostSignUpRequest
import com.riging_test.template.src.sign_up.third.models.PostSignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignThirdRetrofitInterface {

    @POST("/users/logIn")
    fun postSignUp(@Body parms:PostSignUpRequest): Call<PostSignUpResponse>

}