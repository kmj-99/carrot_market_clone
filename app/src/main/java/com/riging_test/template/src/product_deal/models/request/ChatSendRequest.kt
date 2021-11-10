package com.riging_test.template.src.product_deal.models.request

import com.google.gson.annotations.SerializedName

data class ChatSendRequest (
    @SerializedName("content") val content: String,

)