package com.riging_test.template.src.main._1home.models

data class HomePostListDataClass(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)