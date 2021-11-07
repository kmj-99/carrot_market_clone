package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment2.models

data class SalesFinishResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)