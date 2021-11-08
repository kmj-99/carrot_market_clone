package com.riging_test.template.src.product.models.request

import com.google.gson.annotations.SerializedName

data class AddRequest (

    @SerializedName("userId") val userId: Int,
    @SerializedName("postId") val postId: Int
)