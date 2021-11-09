package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface MyFavoriteInterface {

    @GET("wish-list")
    fun getFavoriteList(@Header("X-ACCESS-TOKEN")jwt:String
    ):retrofit2.Call<MyFavoriteListResponse>
}