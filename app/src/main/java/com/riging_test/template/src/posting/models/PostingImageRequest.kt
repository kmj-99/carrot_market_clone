package com.riging_test.template.src.posting.models

import com.google.gson.annotations.SerializedName

data class PostingImageRequest(
    @SerializedName("postId") val postId: Int,
    @SerializedName("image") val image: String

)