package com.riging_test.template.src.main._1home

import com.riging_test.template.src.main._1home.models.HomePostListDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface HomeFragmentInterface {
    @GET("post")
    fun getPostList(@Header("X-ACCESS-TOKEN")Jwt:String,
                    @Query("townId")townId:Int,
                    @Query("range")range:Int
    ):Call<HomePostListDataClass>
}