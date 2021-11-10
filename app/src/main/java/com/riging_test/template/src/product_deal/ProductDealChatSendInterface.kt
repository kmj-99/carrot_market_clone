package com.riging_test.template.src.product_deal

import com.riging_test.template.src.product.models.response.FavoriteListResponse
import com.riging_test.template.src.product_deal.models.request.ChatAddRequest
import com.riging_test.template.src.product_deal.models.request.ChatSendRequest
import com.riging_test.template.src.product_deal.models.response.ChatSendResponse
import retrofit2.Call
import retrofit2.http.*

interface ProductDealChatSendInterface {

    @POST("chatting/{chattingRoomId}/content")
    fun postSendChat(@Header("X-ACCESS-TOKEN")Jwt:String,
                     @Path("chattingRoomId")chattingRoomId:Int,
                     @Body parms: ChatSendRequest
    ): Call<ChatSendResponse>

}