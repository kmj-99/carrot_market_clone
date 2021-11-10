package com.riging_test.template.src.product_deal.models.request

import com.google.gson.annotations.SerializedName

data class ChatAddRequest (
    @SerializedName("buyerUserId") val buyerUserId: Int,
    @SerializedName("postId") val postId: Int

)