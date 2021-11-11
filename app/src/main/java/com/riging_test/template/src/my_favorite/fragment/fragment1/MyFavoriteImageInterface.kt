package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.src.main._1home.models.FavoriteImageResponse
import com.riging_test.template.src.main._1home.models.HomeTitleImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyFavoriteImageInterface {

    @GET("post/title-image")
    fun getFavoriteImage(@Query("postId")postId:Int
    ): Call<FavoriteImageResponse>
}