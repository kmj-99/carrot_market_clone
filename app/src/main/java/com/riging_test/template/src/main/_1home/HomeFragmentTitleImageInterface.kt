package com.riging_test.template.src.main._1home

import com.riging_test.template.src.main._1home.models.HomeTitleImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeFragmentTitleImageInterface {

    @GET("post/title-image")
    fun getTitleImage(@Query("postId")postId:Int
    ):Call<HomeTitleImageResponse>
}