package com.riging_test.template.src.product

import com.riging_test.template.src.main._1home.models.PostIdRresponse
import com.riging_test.template.src.product.models.response.ImageListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductImageListInterface {


    @GET("post/image")
    fun getImageList(@Query("postId")postId:Int
    ): Call<ImageListResponse>
}