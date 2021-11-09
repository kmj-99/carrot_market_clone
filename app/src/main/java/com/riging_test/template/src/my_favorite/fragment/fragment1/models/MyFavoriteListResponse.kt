package com.riging_test.template.src.my_favorite.fragment.fragment1.models

data class MyFavoriteListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)