package com.riging_test.template.src.product.models.response

data class ImageListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultXX>
)