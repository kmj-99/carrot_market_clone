package com.riging_test.template.src.my_carrot_sales_history.fragment.fragment1.models

data class SalesIngResonse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<Result>
)