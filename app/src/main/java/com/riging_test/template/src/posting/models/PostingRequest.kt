package com.riging_test.template.src.posting.models

import com.google.gson.annotations.SerializedName

data class PostingRequest(
    @SerializedName("userId") val userId: Int,
    @SerializedName("townId") val townId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("categoryId") val categoryId: Int,
    @SerializedName("cost") val cost: Int,
    @SerializedName("content") val content: String

)