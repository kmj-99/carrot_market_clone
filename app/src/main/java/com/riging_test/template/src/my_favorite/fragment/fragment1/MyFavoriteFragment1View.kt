package com.riging_test.template.src.my_favorite.fragment.fragment1

import com.riging_test.template.src.my_favorite.fragment.fragment1.models.MyFavoriteListResponse

interface MyFavoriteFragment1View {

    fun getFavoriteListSuccess(response: MyFavoriteListResponse)
    fun getFavoriteListFailure(message:String)
}