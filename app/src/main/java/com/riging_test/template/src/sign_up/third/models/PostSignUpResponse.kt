package com.riging_test.template.src.sign_up.third.models

data class PostSignUpResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)