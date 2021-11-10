package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models.ImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HistoryFragment2ImageInterface {

    @GET("post/title-image")
    fun getTitleImage(@Query("postId")postId:Int
    ): Call<ImageResponse>

}