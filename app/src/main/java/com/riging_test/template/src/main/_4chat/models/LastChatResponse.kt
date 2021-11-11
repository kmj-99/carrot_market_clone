package com.riging_test.template.src.main._4chat.models

data class LastChatResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultX
)