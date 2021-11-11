package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.src.main._1home.models.FavoriteImageResponse
import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse

interface MyFavoriteFragment1View {

    fun getFavoriteListSuccess(response: MyFavoriteListResponse)
    fun getFavoriteListFailure(message:String)

    fun getFavoriteImageSuccess(response:FavoriteImageResponse)
    fun getFavoriteImageFailure(message:String)
}