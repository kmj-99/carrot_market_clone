package com.riging_test.template.src.main._4chat

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.TitleImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChatProductIImageInterface {

    @GET("post/title-image")
    fun getTitleImage(@Query("postId")postId:Int
    ):Call<TitleImageResponse>
}