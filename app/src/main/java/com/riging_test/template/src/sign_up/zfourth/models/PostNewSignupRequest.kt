package com.riging_test.template.src.sign_up.zfourth.models

import com.google.gson.annotations.SerializedName

data class PostNewSignupRequest (

    @SerializedName("city") val city: String,
    @SerializedName("district") val district: String,
    @SerializedName("townName") val townName: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("nickName") val nickName: String,
    @SerializedName("image") val image: String

)