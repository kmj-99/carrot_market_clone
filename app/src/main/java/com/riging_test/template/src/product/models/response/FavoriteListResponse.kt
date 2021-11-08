package com.riging_test.template.src.product.models.response

data class FavoriteListResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ResultX>
)