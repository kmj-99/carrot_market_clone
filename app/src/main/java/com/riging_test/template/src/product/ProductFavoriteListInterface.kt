package com.riging_test.template.src.product

import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product.models.response.FavoriteListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProductFavoriteListInterface {


    @GET("wish-list")
    fun getFavoriteList(@Header("X-ACCESS-TOKEN")Jwt:String
    ): Call<FavoriteListResponse>
}