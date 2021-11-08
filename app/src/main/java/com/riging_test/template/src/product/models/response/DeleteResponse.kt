package com.riging_test.template.src.product.models.response

data class DeleteResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: String
)