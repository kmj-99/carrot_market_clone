package com.riging_test.template.src.product_deal.models.response

data class ChatSendResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultX
)