package com.riging_test.template.src.main._1home

import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models.SalesIngResonse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeGetPostIdInterface {

    @GET("post/{userId}")
    fun getPostId(@Path("userId")userId:Int
    ): Call<PostIdRresponse>
}