package com.riging_test.template.src.main._4chat

import com.riging_test.template.src.main._4chat.models.ChatListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ChatListInterface {

    @GET("chatting")
    fun getChatList(@Header("X-ACCESS-TOKEN")jwt:String
    ):Call<ChatListResponse>
}