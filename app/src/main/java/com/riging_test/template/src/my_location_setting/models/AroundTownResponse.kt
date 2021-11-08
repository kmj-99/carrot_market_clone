package com.riging_test.template.src.my_location_setting.models

data class AroundTownResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)