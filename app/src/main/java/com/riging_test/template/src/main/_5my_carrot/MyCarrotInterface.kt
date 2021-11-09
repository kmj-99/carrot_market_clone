package com.riging_test.template.src.main._5my_carrot

import com.riging_test.template.src.main._5my_carrot.model.UserInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyCarrotInterface {

    @GET("users/{userId}")
    fun getUserInfo(@Path("userId") userId:Int
    ):Call<UserInfoResponse>
}