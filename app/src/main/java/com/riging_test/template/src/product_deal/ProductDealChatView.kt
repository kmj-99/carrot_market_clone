package com.riging_test.template.src.product_deal

import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product_deal.models.response.ChatAddResponse
import com.riging_test.template.src.product_deal.models.response.ChatSendResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ProductDealChatView {

    fun postAddSuccess(response:ChatAddResponse)
    fun postAddFailure(message:String)

    fun postSendSuccess(response:ChatSendResponse)
    fun postSendFailure(message:String)


}