package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment3.models

data class SalesHideResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)