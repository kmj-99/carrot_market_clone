package com.riging_test.template.src.sign_up.second.models

data class AroundLocationResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultX>
)