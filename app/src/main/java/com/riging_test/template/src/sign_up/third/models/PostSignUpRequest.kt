package com.riging_test.template.src.sign_up.third.models

import com.google.gson.annotations.SerializedName

data class PostSignUpRequest(
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("certificationNum") val certificationNum: String

)