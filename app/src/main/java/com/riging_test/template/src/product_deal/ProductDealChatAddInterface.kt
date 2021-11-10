package com.riging_test.template.src.product_deal

import com.riging_test.template.src.product.models.request.AddRequest
import com.riging_test.template.src.product.models.response.AddResponse
import com.riging_test.template.src.product_deal.models.request.ChatAddRequest
import com.riging_test.template.src.product_deal.models.response.ChatAddResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductDealChatAddInterface {

    @POST("chatting/{sellerUserId}")
    fun postAddChat(@Body parms: ChatAddRequest,
                    @Path("sellerUserId")sellerUserId:Int
    ):Call<ChatAddResponse>


}