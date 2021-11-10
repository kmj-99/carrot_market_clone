package com.riging_test.template.src.product_deal

import com.riging_test.template.config.ApplicationClass
import com.riging_test.template.src.product_deal.models.request.ChatAddRequest
import com.riging_test.template.src.product_deal.models.request.ChatSendRequest
import com.riging_test.template.src.product_deal.models.response.ChatAddResponse
import com.riging_test.template.src.product_deal.models.response.ChatSendResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatService(val view:ChatView) {


    fun TryPostAdd(addRequest: ChatAddRequest, sellerUserId:Int){

        val postAddChatRetrofitInterface= ApplicationClass.sRetrofit.create(
            ChatAddInterface::class.java)

        postAddChatRetrofitInterface.postAddChat(addRequest,sellerUserId).enqueue(object:
            Callback<ChatAddResponse> {
            override fun onResponse(
                call: Call<ChatAddResponse>,
                response: Response<ChatAddResponse>
            ) {
                if(response.body()!=null){
                    view.postAddSuccess(response.body() as ChatAddResponse)
                }

            }

            override fun onFailure(call: Call<ChatAddResponse>, t: Throwable) {
                view.postAddFailure(t.message?:"통신오류")

            }

        })

    }



    fun TryPostSend(jwt:String,chattingRoomId:Int,chatSendRequest: ChatSendRequest){

        val postSendChatRetrofitInterface= ApplicationClass.sRetrofit.create(
            ChatSendInterface::class.java)

        postSendChatRetrofitInterface.postSendChat(jwt,chattingRoomId,chatSendRequest).enqueue(object:
            Callback<ChatSendResponse> {
            override fun onResponse(
                call: Call<ChatSendResponse>,
                response: Response<ChatSendResponse>
            ) {
                if(response.body()!=null){
                    view.postSendSuccess(response.body() as ChatSendResponse)
                }

            }

            override fun onFailure(call: Call<ChatSendResponse>, t: Throwable) {
                view.postSendFailure(t.message?:"통신오류")

            }

        })

    }
}