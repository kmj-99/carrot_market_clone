package com.riging_test.template.src.sign_up.zfourth.models

data class SignupResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)