package com.riging_test.template.src.main._5my_carrot.model

data class UserInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)