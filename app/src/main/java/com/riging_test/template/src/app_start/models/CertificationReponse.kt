package com.riging_test.template.src.app_start.models

data class CertificationReponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)