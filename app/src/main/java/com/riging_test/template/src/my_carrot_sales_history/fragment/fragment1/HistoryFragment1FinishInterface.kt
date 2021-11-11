package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1

import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.ProductChangeFinishResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Path

interface HistoryFragment1FinishInterface {

    @PATCH("post/{postId}/complete/{buyerUserId}")
    fun pathChangeFinish(@Header("X-ACCESS-TOKEN")jwt:String,
                         @Path("postId")postId:Int,
                         @Path("buyerUserId")buyerUserId:Int
    ):Call<ProductChangeFinishResponse>
}