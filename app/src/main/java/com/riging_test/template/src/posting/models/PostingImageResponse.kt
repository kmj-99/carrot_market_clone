package com.riging_test.template.src.posting.models

data class PostingImageResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ResultX
)