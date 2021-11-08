package com.riging_test.template.src.product.models.request

import com.google.gson.annotations.SerializedName

data class DeleteRequest (

    @SerializedName("status") val status: String

)